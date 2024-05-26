package com.example.module1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    public void agree(View view) {
        // Open the login page
        startActivity(new Intent(this, login.class));
    }

    public void disagree(View view) {
        // Close the app
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


    }
}