package com.example.coldcallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalledLogActivity extends AppCompatActivity {

    private Button mMainMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_log);

        mMainMenuButton = findViewById(R.id.main_menu_button);
        mMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalledLogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}