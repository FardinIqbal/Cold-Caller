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

public class UncalledLogActivity extends AppCompatActivity {

    private Button mMainMenuButton;
    private ArrayList<Student> mUncalledLog;
    private ListView mListView;

    //from the model layout
    private ImageView studentImage;
    private TextView student,callTracker,dateAndTimeLastCalled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uncalled_log);

        mMainMenuButton = findViewById(R.id.main_menu_button);
        mMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        mUncalledLog = (ArrayList<Student>) args.getSerializable("ARRAYLIST");
        Log.d("test", "uncalled print: " + mUncalledLog.toString());
        mListView = (ListView) findViewById(R.id.list_view2);
        ArrayAdapter adapter = new ArrayAdapter<Student>(
                UncalledLogActivity.this,
                R.layout.list_view_layout,
                mUncalledLog
        );
        mListView.setAdapter(adapter);
    }
}