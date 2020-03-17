package com.example.hometesting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText etID,etPass,etMail,etRePass;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etID = findViewById(R.id.etID);
        etPass = findViewById(R.id.etPass);
        etMail = findViewById(R.id.etMail);
        etRePass = findViewById(R.id.etRePass);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,mail,pass,rePass;
                id = etID.getText().toString();
                pass = etPass.getText().toString();
                mail = etMail.getText().toString();
                rePass = etRePass.getText().toString();

                if (id.equals("")){
                    Toast.makeText(Register.this, "Cần nhập tài khoản",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals("")){
                    Toast.makeText(Register.this,"Cần nhập mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else if (mail.equals("")){
                    Toast.makeText(Register.this,"Cần nhập mail",Toast.LENGTH_SHORT).show();
                }
                else if (rePass.equals("")){
                    Toast.makeText(Register.this,"Cần nhập lại mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
    }
}
