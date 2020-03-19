package com.example.hometesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    EditText etID,etPass,etMail,etRePass;
    Button btnReg;
    FirebaseAuth mFirebaseAuth;
    TextView tvLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etID = findViewById(R.id.etID);
        etPass = findViewById(R.id.etPass);
        etMail = findViewById(R.id.etMail);
        etRePass = findViewById(R.id.etRePass);
        mFirebaseAuth = FirebaseAuth.getInstance();
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Home.this, MainActivity.class);
                startActivity(j);
            }

        });
    }
}
