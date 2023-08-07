package com.tolietpaperprices.View;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View.OnClickListener;

import com.google.android.material.snackbar.Snackbar;
import com.tolietpaperprices.databinding.ActivityMainBinding;

/**
 * Class for the main view (primarily menu)
 *
 * @author Emily
 */
public class MainView implements IMainView {
    FragmentManager fragmentManager;
    ActivityMainBinding binding;
    Listener listener;

    /**
     * MainView constructor
     * @param activity android activity
     */
    public MainView(Listener listener, FragmentActivity activity) {
        this.fragmentManager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
        this.listener = listener;

        Button aboutButton = this.binding.aboutMenuButton;
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.onAboutMenuButton();
            }
        });

        Button displayButton = this.binding.displayMenuButton;
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.onDisplayMenuButton();
            }
        });

        Button addButton = this.binding.addMenuButton;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.onAddMenuButton();
            }
        });
    }

    /**
     * Returns highest root view of the screen
     */
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    /**
     * Displays the fragment
     * @param fragment
     * @param allowBack whether back button can return to fragment
     * @param name
     */
    @Override
    public void displayFragment(Fragment fragment, boolean allowBack, String name) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.replace(this.binding.mainFragmentContainer.getId(), fragment);
        if (allowBack) {
            ft.addToBackStack(name);
        }
        ft.commit();
    }
}
