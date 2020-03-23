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

public class Home extends AppCompatActivity {
    EditText etID,etPass,etMail,etRePass;
    Button btnSignUp;
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

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (etID.equals("")){
                    Toast.makeText(Home.this, "Cần nhập tài khoản",Toast.LENGTH_SHORT).show();
                }
                else if (etPass.equals("")){
                    Toast.makeText(Home.this,"Cần nhập mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else if (etMail.equals("")){
                    Toast.makeText(Home.this,"Cần nhập mail",Toast.LENGTH_SHORT).show();
                }
                else if (etRePass.equals("")){
                    Toast.makeText(Home.this,"Cần nhập lại mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else {
                    mFirebaseAuth.createUserWithEmailAndPassword(etMail.toString(), etPass.toString()).addOnCompleteListener(Home.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Home.this,"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(Home.this,homee.class));
                            }
                        }
                    });
                }
            }
        });

    }
}
