package com.example.onlineclothingshop;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.LoginFragment;
import fragments.RegisterFragment;

public class MainActivity extends AppCompatActivity {
private Button btnLogin;
private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);

       btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fragmentManager=getSupportFragmentManager();
               FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

               RegisterFragment registerFragment=new RegisterFragment();
               fragmentTransaction.add(R.id.fragmentContainer,registerFragment);
               fragmentTransaction.commit();


           }
       });

       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fragmentManager=getSupportFragmentManager();
               FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

               LoginFragment loginFragment=new LoginFragment();
               fragmentTransaction.add(R.id.fragmentContainer,loginFragment);
               fragmentTransaction.commit();


           }
       });
    }


}
