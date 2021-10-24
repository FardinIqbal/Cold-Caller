package com.example.coldcallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CalledLogActivity extends AppCompatActivity {

    private Button mMainMenuButton;
    private ArrayList<Student> mCalledLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_log);

        mMainMenuButton = findViewById(R.id.main_menu_button);
        mMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        mCalledLog = (ArrayList<Student>) args.getSerializable("ARRAYLIST");

        TextView student = findViewById(R.id.student_name);
        student.setText(mCalledLog.get(0).getName());

        ImageView studentImage = findViewById(R.id.student_image);
        studentImage.setImageResource(mCalledLog.get(0).getImage());

        TextView dateAndTimeLastCalled = findViewById(R.id.date_and_time_last_called);
        dateAndTimeLastCalled.setText(mCalledLog.get(0).getLastDateAndTimeCalled());

        TextView callTracker = findViewById(R.id.call_tracker);
        callTracker.setText(mCalledLog.get(0).getCallTracker() + "");
    }

}