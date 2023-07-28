package com.tolietpaperprices.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class containing information for one package of toliet paper
 *
 * @author Emily
 */
public class TolietPaperPackage implements Serializable, Comparable<TolietPaperPackage> {

    public enum Style{
        SOFT, STRONG, NORMAL
    }

    String brand;
    Style style;
    double price;
    int numRolls;
    int numSquaresPerRoll;
    double pricePerSquare;
    String storeName;
    String storeTown;
    LocalDateTime dateOfEntry;

    /**
     * Default constructor
     * @param brand
     * @param style
     * @param price
     * @param numRolls
     * @param numSquaresPerRoll
     * @param storeName
     * @param storeTown
     */
    public TolietPaperPackage(String brand, Style style, double price, int numRolls,
                              int numSquaresPerRoll, String storeName, String storeTown) {
        this.brand = brand;
        this.style = style;
        this.price = price;
        this.numRolls = numRolls;
        this.numSquaresPerRoll = numSquaresPerRoll;
        this.storeName = storeName;
        this.storeTown = storeTown;
        this.dateOfEntry = LocalDateTime.now();
        this.pricePerSquare = this.price / (this.numSquaresPerRoll * this.numRolls);
    }

    /**
     * Getters and setters for TolietPaperPackage
     */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumRolls() {
        return numRolls;
    }

    public void setNumRolls(int numRolls) {
        this.numRolls = numRolls;
    }

    public int getNumSquaresPerRoll() {
        return numSquaresPerRoll;
    }

    public void setNumSquaresPerRoll(int numSquaresPerRoll) {
        this.numSquaresPerRoll = numSquaresPerRoll;
    }

    public double getPricePerSquare() {
        return pricePerSquare;
    }

    public void calculatePricePerSquare() {
        this.pricePerSquare = this.price / (this.numSquaresPerRoll * this.numRolls);
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreTown() {
        return storeTown;
    }

    public void setStoreTown(String storeTown) {
        this.storeTown = storeTown;
    }

    public LocalDateTime getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDateTime dateOfEntry) {
        this.dateOfEntry = LocalDateTime.now();
    }

    /**
     * Compares the packages based price per square
     * @param o
     * @return 1 when the first object is more expensive; -1 when less; 0 when equal
     */
    @Override
    public int compareTo(TolietPaperPackage o) {
        if (this.pricePerSquare > o.getPricePerSquare()) {
            return 1;
        }
        if (this.pricePerSquare < o.getPricePerSquare()) {
            return -1;
        }
        return 0;
    }
}