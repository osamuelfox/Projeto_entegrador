package com.samuel_fox.calendar.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.samuel_fox.calendar.CalendarViewWithNotesActivitySDK21;
import com.samuel_fox.calendar.R;


public class MainActivity extends AppCompatActivity {

        // Constante Contenido Actividad
        private final static int CONT_ACTIVIDAD = 0;
        private DrawerLayout drawerLayout;
        private NavigationView nav;
        private ViewFlipper vf;
        Toolbar toolbar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            toolbar = findViewById(R.id.toolbar1);

            // Componente ViewFlipper
            vf = (ViewFlipper)findViewById(R.id.vf);
            vf.setDisplayedChild(CONT_ACTIVIDAD);

            // Componente NavigationDrawer
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            nav = (NavigationView) findViewById(R.id.nav_view);


            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent sendIntent;
                    if (item.getItemId() == R.id.nav_item_one) {
                        // Se inicia Actividad 1
                        sendIntent = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(sendIntent);
                    } else if (item.getItemId() == R.id.nav_item_two) {
                        // Se inicia Actividad 2
                        sendIntent = new Intent(MainActivity.this, CalendarViewWithNotesActivitySDK21.class);
                        startActivity(sendIntent);
                    }

                    // Close the navigation drawer when an item is selected
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

