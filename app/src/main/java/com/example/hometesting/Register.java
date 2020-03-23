package com.example.hometesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText etID,etPass,etMail,etRePass;
    Button btnReg;
    FirebaseAuth mFirebaseAuth;
    TextView tvLogin;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etID = findViewById(R.id.etID);
        etPass = findViewById(R.id.etPass);
        etMail = findViewById(R.id.etMail);
        etRePass = findViewById(R.id.etRePass);
        mFirebaseAuth = FirebaseAuth.getInstance();

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
                    mFirebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this,"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(Register.this,Home.class));
                            }
                        }
                    });
                }
                //else {
                //    Toast.makeText(Register.this,"Lỗi không xác định",Toast.LENGTH_SHORT).show();
               // }

            }
        });

        //tvLogin.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   Intent i = new Intent(Register.this,MainActivity.class);
              //  startActivity(i);
           // }
        //});
    }
}
