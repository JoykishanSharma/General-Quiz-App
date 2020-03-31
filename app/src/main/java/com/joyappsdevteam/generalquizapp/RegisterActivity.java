package com.joyappsdevteam.generalquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_username,reg_email,reg_password;
    private CardView reg_button;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_username = findViewById(R.id.reg_username);
        reg_password = findViewById(R.id.reg_password);
        reg_email = findViewById(R.id.reg_email);
        reg_button = findViewById(R.id.cardView1);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg_name = reg_username.getText().toString().trim();
                String reg_mail = reg_email.getText().toString().trim();
                String reg_pass = reg_password.getText().toString().trim();

                if (TextUtils.isEmpty(reg_name)) {
                    reg_username.setError("Username is Empty");
                }
                else if (TextUtils.isEmpty(reg_mail)){
                    reg_email.setError("Email is Empty");
                }
                else if (TextUtils.isEmpty(reg_pass)){
                    reg_password.setError("Password is Empty");
                }
                else {
                    if (isConnected()){
                        Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_SHORT).show();
                        finish();
                        overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

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
}
