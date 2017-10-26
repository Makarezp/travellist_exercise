package com.believeapps.travelinfo.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.believeapps.travelinfo.R;
import com.believeapps.travelinfo.screens.settings.SettingsActivity;
import com.believeapps.travelinfo.screens.travellist.TravelListFrag;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_TRAVEL_LIST = "travel_list";
    private static final String TAG_SETTINGS = "settings";

    //current active fragment
    public static String CURRENT_TAG = TAG_TRAVEL_LIST;

    private Handler mHandler;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        mHandler = new Handler();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_TRAVEL_LIST;
            loadFragment();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.travel_list) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_SETTINGS;
        } else if (id == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }

        item.setChecked(true);
        loadFragment();
        return true;
    }


    private void loadFragment() {

        selectNavMenu();

        Runnable mPenndingRunnable = () -> {
            Fragment fragment = getFragment(navItemIndex);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment, CURRENT_TAG)
                    .commit();
        };

        mHandler.post(mPenndingRunnable);

        drawerLayout.closeDrawers();

    }


    private Fragment getFragment(int currNavItemIndex) {
        switch (currNavItemIndex) {
            case 0:
                return TravelListFrag.newInstance();
            default:
                throw new IllegalArgumentException("There is no fragment with index" + currNavItemIndex);
        }
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }
}
