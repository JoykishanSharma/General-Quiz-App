package com.joyappsdevteam.generalquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class AnotherActivity extends AppCompatActivity {

    SpaceNavigationView navigationView1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        //navigationView1 = findViewById(R.id.space1);
        button = findViewById(R.id.clickme);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnotherActivity.this,"Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });


        /*navigationView1.initWithSaveInstanceState(savedInstanceState);
        navigationView1.addSpaceItem(new SpaceItem("", R.drawable.ic_style_black_24dp));
        navigationView1.addSpaceItem(new SpaceItem("", R.drawable.ic_developer_board_black_24dp));
        navigationView1.addSpaceItem(new SpaceItem("", R.drawable.ic_feedback_black_24dp));
        navigationView1.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));


        navigationView1.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(AnotherActivity.this,"Centre Button Clicked", Toast.LENGTH_SHORT).show();
                navigationView1.setCentreButtonSelectable(true);


            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(AnotherActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(AnotherActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
