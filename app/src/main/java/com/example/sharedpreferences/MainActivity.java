package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferencesConfig preferencesConfig;
    private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesConfig=new SharedPreferencesConfig(getApplicationContext());

        username=findViewById(R.id.etUser);
        password=findViewById(R.id.etPass);

        if(preferencesConfig.readloginstatus()){
            startActivity(new Intent(this,Second.class));
            finish();
        }
    }
    public void loginuser(View view){
        String Username=username.getText().toString();
        String Password=password.getText().toString();

        if(Username.equals(getResources().getString(R.string.user_name))&& Password.equals(getResources().getString(R.string.password)))
        {
          startActivity(new Intent(this,Second.class));
          preferencesConfig.writeloginstatus(true);
          finish();
        }
        else{
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }

    }
}
