package com.joyappsdevteam.generalquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView register;
    private EditText login_username, login_password;
    private CardView login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        login_username = findViewById(R.id.editText);
        login_password = findViewById(R.id.editText2);
        login_button = findViewById(R.id.cardView);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.custom_slide_in_right,R.anim.custom_slide_out_left);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = login_username.getText().toString().trim();
                String upass = login_password.getText().toString().trim();

                if (TextUtils.isEmpty(uname)) {
                    login_username.setError("Username is Empty");
                }
                else if (TextUtils.isEmpty(upass)){
                    login_password.setError("Password is Empty");
                }
                else {
                    if (isConnected()){

                        Toast.makeText(LoginActivity.this,"Login Process",Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(LoginActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    private void savedLoginState(){
        SharedPreferences sp = getSharedPreferences("logged_in", MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean("is_logged", true);
        et.apply();
    }

    private boolean isConnected() {

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            return (mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting());
        } else
            return false;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit Application")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            endTask();
                            onDestroy();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void endTask() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAndRemoveTask();
        }
        finish();
    }
}
