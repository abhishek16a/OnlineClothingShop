package com.example.onlineclothingshop;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName,etPassword;
    private Button btnLOgIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);
        btnLOgIn=findViewById(R.id.btnLogIn);

        btnLOgIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });

    }
    private void checkUser(){
        SharedPreferences sharedPreferences=getSharedPreferences("User", MODE_PRIVATE);
        String username= sharedPreferences.getString("username", "");
        String password= sharedPreferences.getString("password", "");
        if (username.equals(etUserName.getText().toString()) ||
                password.equals(etPassword.getText().toString())){
            Toast.makeText(LoginActivity.this, "successful", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(LoginActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }
}