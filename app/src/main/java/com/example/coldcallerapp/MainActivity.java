package com.example.coldcallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Student> mUncalledLog = new ArrayList<Student>();
    public ArrayList<Student> mCalledLog = new ArrayList<Student>();

    public Student currentStudent;

    private Button callRandomButton;
    private Button calledLogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createStudentList();

        updateCurrentStudent();
        displayStudent();
        displayTime();

        handleCallRandomButton();

        calledLogButton = findViewById(R.id.calledLogButton);
        calledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalledLogActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) mCalledLog);
                intent.putExtra("BUNDLE", args);
                startActivity(intent);
            }
        });
    }

    public void handleCallRandomButton() {
        callRandomButton = findViewById(R.id.buttonRandom);
        callRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCurrentStudent();
                updateCurrentStudent();
                displayStudent();
                displayTime();
            }
        });
    }

    public void createStudentList() {
        mUncalledLog.add(new Student(R.string.aamir_ali, R.drawable.aamir_ali));
        mUncalledLog.add(new Student(R.string.alex_aney, R.drawable.alex_aney));
        mUncalledLog.add(new Student(R.string.bipra_dey, R.drawable.bipra_dey));
    }

    public void displayStudent() {
        ImageView img = (ImageView) findViewById(R.id.studentImage);
        img.setImageResource(currentStudent.getImage());

        TextView name = (TextView) findViewById(R.id.nameTextView);
        name.setText(currentStudent.getName());
    }

    public void displayTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        String strDate = dateFormat.format(date);

        TextView timeTextView = (TextView) findViewById(R.id.timeTextView);
        timeTextView.setText(strDate);
    }

    public void updateCurrentStudent() {
        currentStudent = mUncalledLog.get((int) (Math.random() * mUncalledLog.size()));
        mCalledLog.add(currentStudent);
    }
}
