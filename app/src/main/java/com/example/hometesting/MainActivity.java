package com.example.hometesting;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText etID,etPass;
    Button btnLogin;
    TextView tvReg;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);

        mFirebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,pass;
                id = etID.getText().toString();
                pass = etPass.getText().toString();

                if (id.equals("")){
                    Toast.makeText(MainActivity.this, "Cần nhập tài khoản",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals("")){
                    Toast.makeText(MainActivity.this,"Cần nhập mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else {
                }
            }
        });
        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Home.class);
                startActivity(i);
                finish();
            }
        });
    }
}
