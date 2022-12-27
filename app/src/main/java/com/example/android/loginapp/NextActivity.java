package com.example.android.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView next_screen_name , next_screen_id;
    Button logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        next_screen_name = findViewById(R.id.next_screen_name);
        next_screen_id = findViewById(R.id.next_screen_id);
        logout_btn = findViewById(R.id.logout_btn);

        SharedPreferences pref = getSharedPreferences(
                String.valueOf(R.string.shared_pref_name) , MODE_PRIVATE);

        // retrieve the data in name and id variable and set the data in textview.
        String name = pref.getString(String.valueOf(R.string.user_name) , null);
        next_screen_name.setText(name);

        String id = pref.getString(String.valueOf(R.string.user_id) , null);
        next_screen_id.setText(id);

        // log out button function. it clear all the data that send by prefrence
        // and sent us back to the login page.
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(NextActivity.this ,MainActivity.class );
                startActivity(intent);
            }
        });



    }
}