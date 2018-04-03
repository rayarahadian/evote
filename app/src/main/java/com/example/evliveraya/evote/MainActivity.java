package com.example.evliveraya.evote;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private Bundle extras, dataToFragment;
    private DBHandler dbHandler;
    private User user;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(this);
        extras = getIntent().getExtras();
        dataToFragment = new Bundle();
        email = "";
        user = new User();
        if (extras != null) {
            email = extras.getString("email");
            user = dbHandler.getUser(email);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        navigationView = (NavigationView) findViewById(R.id.main_navigation);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = new FragmentMainMenu();
        dataToFragment.putString("email", email);
        fragment.setArguments(dataToFragment);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fragmentSelected(int itemID) {
        Fragment fragment = null;
        String email = "";
        switch (itemID) {
            case R.id.navigation_menu:
                fragment = new FragmentMainMenu();
                if (extras != null) {
                    email = extras.getString("email");
                }
                dataToFragment = new Bundle();
                dataToFragment.putString("email", email);
                fragment.setArguments(dataToFragment);
                break;
            case R.id.navigation_my_account:
                fragment = new FragmentMyAccount();
                if (extras != null) {
                    email = extras.getString("email");
                }
                dataToFragment = new Bundle();
                dataToFragment.putString("email", email);
                fragment.setArguments(dataToFragment);
                break;
            case R.id.navigation_vote:
                fragment = new FragmentVote();
                if (extras != null) {
                    email = extras.getString("email");
                }
                dataToFragment = new Bundle();
                dataToFragment.putString("email", email);
                fragment.setArguments(dataToFragment);
                break;
            case R.id.navigation_quick_count:
                fragment = new FragmentQuickCount();
                if (extras != null) {
                    email = extras.getString("email");
                }
                dataToFragment = new Bundle();
                dataToFragment.putString("email", email);
                fragment.setArguments(dataToFragment);
                break;
            case R.id.navigation_logout:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_fragment, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragmentSelected(item.getItemId());
        return true;
    }

}
