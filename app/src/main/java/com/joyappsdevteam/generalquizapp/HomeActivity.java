package com.joyappsdevteam.generalquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.feedback:
                        startActivity(new Intent(getApplicationContext(),FeedbackActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),AnotherActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.style_palette:

                        Toast.makeText(getApplicationContext(),"style_pallete is clicked",Toast.LENGTH_SHORT).show();

                        //startActivity(new Intent(getApplicationContext(),AnotherActivity.class));
                        //overridePendingTransition(0,0);
                        return true;

                    case R.id.settings:

                        Toast.makeText(getApplicationContext(),"settings is clicked",Toast.LENGTH_SHORT).show();

                        //startActivity(new Intent(getApplicationContext(),AnotherActivity.class));
                        //overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

    }
}
