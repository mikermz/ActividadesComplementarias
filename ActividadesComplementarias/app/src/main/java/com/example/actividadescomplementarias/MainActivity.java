package com.example.actividadescomplementarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userName, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.userName);
        password = (TextView) findViewById(R.id.editTextTextPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        this.getSupportActionBar().hide();
        loginBtn.setOnClickListener((view)->{
            Intent intent = new Intent(this, AdminView.class);
            startActivity(intent);
        });
    }
}