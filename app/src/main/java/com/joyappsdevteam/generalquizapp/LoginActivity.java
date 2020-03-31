package com.joyappsdevteam.generalquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
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
                    Toast.makeText(LoginActivity.this,"Login Process",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
