package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Second extends AppCompatActivity {
    private SharedPreferencesConfig preferencesConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        preferencesConfig=new SharedPreferencesConfig(getApplicationContext());
    }

    public void userlogout(View view) {
        preferencesConfig.writeloginstatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
