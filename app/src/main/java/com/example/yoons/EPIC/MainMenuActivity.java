package com.example.yoons.EPIC;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
//import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity implements SelectBrandFragment.OnFragmentInteractionListener
{

    //private TextView mTextMessage;
    //Bottom Navigator Part
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId())
            {
                case com.example.yoons.EPIC.R.id.navigation_deviceSetup:
                    transaction.replace(com.example.yoons.EPIC.R.id.content,new SetupScreenFragment()).commit();
                    return true;
                case com.example.yoons.EPIC.R.id.navigation_home:
                    transaction.replace(com.example.yoons.EPIC.R.id.content,new HomeFragment()).commit();
                    return true;
                case com.example.yoons.EPIC.R.id.navigation_notifications:
                    transaction.replace(com.example.yoons.EPIC.R.id.content,new NotificationFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    //Main Activity Part
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(com.example.yoons.EPIC.R.layout.activity_main_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(com.example.yoons.EPIC.R.id.navigation);
        navigation.setSelectedItemId(com.example.yoons.EPIC.R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(com.example.yoons.EPIC.R.id.content,new HomeFragment()).commit();

    }

   @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}
