package com.example.demexamentest;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.demexamentest.fragments.Main;
import com.example.demexamentest.fragments.ProfilePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ProfilePage profilePage = new ProfilePage();
    private Main main = new Main();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_wrapp, main).commit();


        bottomNavigationView.setOnItemSelectedListener(v -> {
            switch (v.getItemId()) {
                case R.id.profilePage:
                    moveToPage(profilePage);

                    break;
                case R.id.mainPage:
                    moveToPage(main);
            }
            return true;
        });

    }

    private void moveToPage(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_wrapp, fragment).commit();
    }
}