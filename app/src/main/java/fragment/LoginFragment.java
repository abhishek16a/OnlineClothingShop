package fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingshop.DashboardActivity;
import com.example.onlineclothingshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements  View.OnClickListener{
    private  Button btnLogin;
    private EditText Username_Login,Password_Login;



    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin=view.findViewById(R.id.btnLogin);
        Username_Login=view.findViewById(R.id.etUsername_Login);
        Password_Login=view.findViewById(R.id.etPassword_Login);

        btnLogin.setOnClickListener(this);

        return view;
    }
    public void onClick(View v){
        if(!validate()){
            return;
        }
        checkLogin();

    }
    private void checkLogin(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");

        String uname=Username_Login.getText().toString();
        String pass=Password_Login.getText().toString();
        if(username.equals(uname) && password.equals(pass)){
            Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(getActivity(), "Username or password doesn't match", Toast.LENGTH_SHORT).show();

        }
    }
    public Boolean validate(){
        boolean isValid=true;
        if(TextUtils.isEmpty(Username_Login.getText().toString())){
            Username_Login.setError("Please Enter Username");
            Username_Login.requestFocus();
            isValid=false;
        }else if (TextUtils.isEmpty(Password_Login.getText().toString())){
            Password_Login.setError("Please Enter Password");
            Password_Login.requestFocus();
            isValid=false;

        }
        return isValid;
    }

}
