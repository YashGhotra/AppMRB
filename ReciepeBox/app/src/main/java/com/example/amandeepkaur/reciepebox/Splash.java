package com.example.amandeepkaur.reciepebox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.amandeepkaur.reciepebox.model.Login;

import java.lang.reflect.AccessibleObject;

/**
 * Created by Amandeep Kaur on 7/04/2016.
 */
public class Splash extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onResume() {
        Intent  intent  = new Intent(this, LoginActivity.class);
        startActivity(intent);

        super.onResume();
    }
}
