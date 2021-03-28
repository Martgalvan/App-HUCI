package com.example.navigationdrawerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectLogin extends AppCompatActivity {

    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myintent = getIntent();
        String email = myintent.getExtras().getString("email");
        String password = myintent.getExtras().getString("pass");

        setContentView(R.layout.correct_login);

        TextView t = (TextView)findViewById(R.id.textViewEmail);
        t.setText(email);
        TextView t2 = (TextView)findViewById(R.id.textViewPassword);
        t2.setText(password);

        buttonLogout = findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CorrectLogin.this, LoginActivity.class);
                startActivity(intent);
                SaveSharedPreference.PREF_USER_NAME = "";
                SaveSharedPreference.PREF_PASS = "";
            }
        });
    }
}