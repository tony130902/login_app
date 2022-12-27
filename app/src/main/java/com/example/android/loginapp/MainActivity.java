package com.example.android.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText loginName , loginId;
    Button loginBtn;
    CheckBox mrememberMe;
    boolean rememberMeCheckBox = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginName = findViewById(R.id.login_name);
        loginId = findViewById(R.id.login_id);
        loginBtn = findViewById(R.id.login_btn);
        mrememberMe = findViewById(R.id.remember_me_login);

        SharedPreferences sharedPreferences = getSharedPreferences(
                String.valueOf(R.string.shared_pref_name), MODE_PRIVATE);

        rememberMeCheckBox = sharedPreferences.getBoolean("Checkbox" , false);

        // for checking condition of checkbox
        if (rememberMeCheckBox){
            Intent intent = new Intent(MainActivity.this ,NextActivity.class );
            startActivity(intent);
        }

        // login button function. it takes the information as shared pref. in editor.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_name = loginName.getText().toString();
                String user_id = loginId.getText().toString();
                boolean checked = mrememberMe.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(String.valueOf(R.string.user_name) , user_name);
                editor.putString(String.valueOf(R.string.user_id) , user_id);
                editor.putBoolean("Checkbox" , checked);
                editor.apply();

                Intent intent = new Intent(MainActivity.this ,NextActivity.class );
                startActivity(intent);
            }
        });

    }
}