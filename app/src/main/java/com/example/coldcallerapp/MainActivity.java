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
    private Button uncalledLogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createStudentList();

        updateCurrentStudent();
        displayStudent();
        displayCurrentDateAndTime();

        handleCallRandomButton();
        handleCalledLogIntent();
        handleUncalledLogIntent();
    }

    public  void handleUncalledLogIntent() {
        uncalledLogButton = findViewById(R.id.uncalled_button_log);
        uncalledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uncalledLogIntent = new Intent(MainActivity.this, UncalledLogActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) mUncalledLog);
                uncalledLogIntent.putExtra("BUNDLE", args);
                startActivity(uncalledLogIntent);
            }
        });
    }

    public void handleCalledLogIntent() {
        calledLogButton = findViewById(R.id.calledLogButton);
        calledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calledLogIntent = new Intent(MainActivity.this, CalledLogActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) mCalledLog);
                calledLogIntent.putExtra("BUNDLE", args);
                startActivity(calledLogIntent);
            }
        });
    }

    public void handleCallRandomButton() {
        callRandomButton = findViewById(R.id.buttonRandom);
        callRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCurrentStudent();
                displayStudent();
                displayCurrentDateAndTime();
            }
        });
    }

    public void createStudentList() {
        mUncalledLog.add(new Student(R.string.aamir_ali, R.drawable.aamir_ali, "Aamir Ali"));
        mUncalledLog.add(new Student(R.string.alex_aney, R.drawable.alex_aney, "Alex Aney"));
        mUncalledLog.add(new Student(R.string.bipra_dey, R.drawable.bipra_dey, "Bipra Dey"));
        mUncalledLog.add(new Student(R.string.daniel_dultsin, R.drawable.daniel_dultsin, "Daniel Dulstin"));
        mUncalledLog.add(new Student(R.string.darren_dong, R.drawable.darren_dong, "Darren Dong"));
        mUncalledLog.add(new Student(R.string.dennis_wang, R.drawable.dennis_wang, "Dennis Wang"));
        mUncalledLog.add(new Student(R.string.dhruv_amin, R.drawable.dhruv_amin, "Dhruv Amin"));
        mUncalledLog.add(new Student(R.string.eden_kodan, R.drawable.eden_kogan, "Eden Kodan"));
        mUncalledLog.add(new Student(R.string.eli_bui, R.drawable.eli_bui, "Eli Bui"));
        mUncalledLog.add(new Student(R.string.elie_belkin, R.drawable.elie_belkin, "Elie Belkin"));
        mUncalledLog.add(new Student(R.string.evelyn_paskhaver, R.drawable.evelyn_paskhaver, "Evelyn Paskhaver"));
        mUncalledLog.add(new Student(R.string.fardin_iqbal, R.drawable.fardin_iqbal, "Fardin Iqbal"));
        mUncalledLog.add(new Student(R.string.jerry_he, R.drawable.jerry_he, "Jerry He"));
        mUncalledLog.add(new Student(R.string.kenny_cao, R.drawable.kenny_cao, "Kenny Cao"));
        mUncalledLog.add(new Student(R.string.marc_rosenberg, R.drawable.marc_rosenberg, "Marc Rosenberg"));
        mUncalledLog.add(new Student(R.string.matthew_chen, R.drawable.matthew_chen, "Matthew Chen"));
        mUncalledLog.add(new Student(R.string.michael_wu, R.drawable.michael_wu, "Micheal Wu"));
        mUncalledLog.add(new Student(R.string.ming_lin, R.drawable.ming_lin, "Ming Lin"));
        mUncalledLog.add(new Student(R.string.mohammed_ihtisham, R.drawable.mohammed_ihtisham, "Mohammed Ihtisham"));
        mUncalledLog.add(new Student(R.string.noam_canter, R.drawable.noam_canter, "Noam Canter"));
        mUncalledLog.add(new Student(R.string.ralf_pacia, R.drawable.ralf_pacia, "Ralf Pacia"));
        mUncalledLog.add(new Student(R.string.samuel_iskhakov, R.drawable.samuel_iskhakov, "Samuel Iskhakov"));
        mUncalledLog.add(new Student(R.string.sean_kerrigan, R.drawable.sean_kerrigan, "Seam Kierrigan"));
        mUncalledLog.add(new Student(R.string.sebastian_marinescu, R.drawable.sebastian_marinescu, "Sebasian Marinescu"));
        mUncalledLog.add(new Student(R.string.selina_li, R.drawable.selina_li, "Selina Li"));
        mUncalledLog.add(new Student(R.string.shuyue_chen, R.drawable.shuyue_chen, "Shuyue Chen"));
        mUncalledLog.add(new Student(R.string.tanushri_sundaram, R.drawable.tanushri_sundaram, "Tanushri Sundaram"));
        mUncalledLog.add(new Student(R.string.vasu_patel, R.drawable.vasu_patel, "Vasu Patel"));
        mUncalledLog.add(new Student(R.string.xinrui_ge, R.drawable.xinrui_ge, "Xinrui Ge"));
        mUncalledLog.add(new Student(R.string.zhian_maysoon, R.drawable.zhian_maysoon, "Zhian Maysoon"));
    }

    public void displayStudent() {
        ImageView img = (ImageView) findViewById(R.id.studentImage);
        img.setImageResource(currentStudent.getImage());

        TextView name = (TextView) findViewById(R.id.nameTextView);
        name.setText(currentStudent.getName());
    }

    public String getCurrentDateAndTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        String strDateAndTime = dateFormat.format(date);
        return strDateAndTime;
    }

    public String getCurrentTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        String strTime = dateFormat.format(date);
        return strTime;
    }

    public void displayCurrentDateAndTime() {
        TextView timeTextView = (TextView) findViewById(R.id.timeTextView);
        timeTextView.setText(getCurrentDateAndTime());
    }

    public void updateCurrentStudent() {
        currentStudent = mUncalledLog.get((int) (Math.random() * mUncalledLog.size()));
        while (currentStudent.getCallTracker() >= 2) {
            currentStudent = mUncalledLog.get((int) (Math.random() * mUncalledLog.size()));
        }
        currentStudent.addToLastDateAndTimeCalled(getCurrentTime());
        currentStudent.setCallTracker(currentStudent.getCallTracker() + 1);
        if (!mCalledLog.contains(currentStudent)) {
            mCalledLog.add(currentStudent);
        }

    }
}
