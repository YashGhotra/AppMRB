package com.example.amandeepkaur.reciepebox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amandeepkaur.reciepebox.http.LoginTask;

/**
 * Created by Amandeep Kaur on 7/04/2016.
 */
public class LoginActivity  extends Activity  implements View.OnClickListener{


     EditText  edtUsername;
     EditText edtPassword;
     Button btnLogin;
     TextView  txtGuest;
    TextView  txtSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        edtUsername   = (EditText)findViewById(R.id.input_username);
        edtPassword    = (EditText)findViewById(R.id.input_password);
         txtSignUp   = (TextView)findViewById(R.id.txt_signup);
        btnLogin   = (Button) findViewById(R.id.btn_signin);
        txtGuest  = (TextView)findViewById(R.id.txt_guest);
        txtGuest.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
         if (v.getId() == R.id.btn_signin){
              login();
         }
        else if (v.getId() == R.id.txt_guest){
           moveToProductScreen();
         }
         else if (v.getId() == R.id.txt_signup){
             moveToSignScreen();
         }
    }

    private void login(){
        if (!(edtPassword.getText().length()>0 && edtUsername.getText().length()>0)){
            Toast.makeText(this, "All fields compulsory",Toast.LENGTH_LONG ).show();
        }
        else if (edtUsername.getText().length()==0){
            Toast.makeText(this, "Please enter username",Toast.LENGTH_LONG ).show();
        }
        else if (edtPassword.getText().length()==0){
            Toast.makeText(this, "Please enter password",Toast.LENGTH_LONG ).show();
        }
        else {
            /*  LoginTask   loginTask  = new LoginTask();

            String[]  serverDetails = new String[1];
            serverDetails [0]="http://myreceipebox.com";
            loginTask.execute(serverDetails);*/

             moveToProductScreen();


        }


    }

    public void moveToProductScreen(){
        Intent  intent  = new Intent(this,ProductActivity.class);
        startActivity(intent);
    }
    public void moveToSignScreen(){
        Intent  intent  = new Intent(this,Signup.class);
        startActivity(intent);
    }

}
