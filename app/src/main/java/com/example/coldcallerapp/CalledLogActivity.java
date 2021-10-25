package com.example.coldcallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CalledLogActivity extends AppCompatActivity {

    private Button mMainMenuButton;
    private ArrayList<Student> mCalledLog;
    private ListView mListView;

    //from the model layout
    private ImageView studentImage;
    private TextView student,callTracker,dateAndTimeLastCalled;

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

        mListView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter adapter = new ArrayAdapter<Student>(
                CalledLogActivity.this,
                R.layout.list_view_layout,
                mCalledLog
        );
        mListView.setAdapter(adapter);

        mListView.setAdapter(adapter);

    }

}