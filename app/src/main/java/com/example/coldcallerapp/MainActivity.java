package com.example.coldcallerapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Student> mAllStudents = new ArrayList<Student>();
    public ArrayList<Student> mAllStudents0 = new ArrayList<Student>();
    public ArrayList<Student> mUncalledStudents = new ArrayList<Student>();
    public ArrayList<Student> mCalledLog = new ArrayList<Student>();

    public Student currentStudent;

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

    public void handleUncalledLogIntent() {
        Button uncalledLogButton = findViewById(R.id.uncalled_log_button);
        uncalledLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calledLogIntent = new Intent(MainActivity.this, UncalledLogActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) mUncalledStudents);
                calledLogIntent.putExtra("BUNDLE", args);
                startActivity(calledLogIntent);
            }
        });
    }

    public void handleCalledLogIntent() {
        Button calledLogButton = findViewById(R.id.called_log_button);
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

    public void remove(Student student) {
        for (Student studentOnList :
                mAllStudents) {
            if (studentOnList.getFullName().equals(student.getFullName())){
                mUncalledStudents.remove(student);
            }
        }
    }

    public void handleCallRandomButton() {
        Button callRandomButton = findViewById(R.id.buttonRandom);
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
        mAllStudents.add(new Student(R.string.aamir_ali, R.drawable.aamir_ali, "Aamir Ali"));
        mAllStudents.add(new Student(R.string.alex_aney, R.drawable.alex_aney, "Alex Aney"));
        mAllStudents.add(new Student(R.string.bipra_dey, R.drawable.bipra_dey, "Bipra Dey"));
        mAllStudents.add(new Student(R.string.daniel_dultsin, R.drawable.daniel_dultsin, "Daniel Dulstin"));
        mAllStudents.add(new Student(R.string.darren_dong, R.drawable.darren_dong, "Darren Dong"));
        mAllStudents.add(new Student(R.string.dennis_wang, R.drawable.dennis_wang, "Dennis Wang"));
        mAllStudents.add(new Student(R.string.dhruv_amin, R.drawable.dhruv_amin, "Dhruv Amin"));
        mAllStudents.add(new Student(R.string.eden_kodan, R.drawable.eden_kogan, "Eden Kodan"));
        mAllStudents.add(new Student(R.string.eli_bui, R.drawable.eli_bui, "Eli Bui"));
        mAllStudents.add(new Student(R.string.elie_belkin, R.drawable.elie_belkin, "Elie Belkin"));
        mAllStudents.add(new Student(R.string.evelyn_paskhaver, R.drawable.evelyn_paskhaver, "Evelyn Paskhaver"));
        mAllStudents.add(new Student(R.string.fardin_iqbal, R.drawable.fardin_iqbal, "Fardin Iqbal"));
        mAllStudents.add(new Student(R.string.jerry_he, R.drawable.jerry_he, "Jerry He"));
        mAllStudents.add(new Student(R.string.kenny_cao, R.drawable.kenny_cao, "Kenny Cao"));
        mAllStudents.add(new Student(R.string.marc_rosenberg, R.drawable.marc_rosenberg, "Marc Rosenberg"));
        mAllStudents.add(new Student(R.string.matthew_chen, R.drawable.matthew_chen, "Matthew Chen"));
        mAllStudents.add(new Student(R.string.michael_wu, R.drawable.michael_wu, "Micheal Wu"));
        mAllStudents.add(new Student(R.string.ming_lin, R.drawable.ming_lin, "Ming Lin"));
        mAllStudents.add(new Student(R.string.mohammed_ihtisham, R.drawable.mohammed_ihtisham, "Mohammed Ihtisham"));
        mAllStudents.add(new Student(R.string.noam_canter, R.drawable.noam_canter, "Noam Canter"));
        mAllStudents.add(new Student(R.string.ralf_pacia, R.drawable.ralf_pacia, "Ralf Pacia"));
        mAllStudents.add(new Student(R.string.samuel_iskhakov, R.drawable.samuel_iskhakov, "Samuel Iskhakov"));
        mAllStudents.add(new Student(R.string.sean_kerrigan, R.drawable.sean_kerrigan, "Seam Kierrigan"));
        mAllStudents.add(new Student(R.string.sebastian_marinescu, R.drawable.sebastian_marinescu, "Sebasian Marinescu"));
        mAllStudents.add(new Student(R.string.selina_li, R.drawable.selina_li, "Selina Li"));
        mAllStudents.add(new Student(R.string.shuyue_chen, R.drawable.shuyue_chen, "Shuyue Chen"));
        mAllStudents.add(new Student(R.string.tanushri_sundaram, R.drawable.tanushri_sundaram, "Tanushri Sundaram"));
        mAllStudents.add(new Student(R.string.vasu_patel, R.drawable.vasu_patel, "Vasu Patel"));
        mAllStudents.add(new Student(R.string.xinrui_ge, R.drawable.xinrui_ge, "Xinrui Ge"));
        mAllStudents.add(new Student(R.string.zhian_maysoon, R.drawable.zhian_maysoon, "Zhian Maysoon"));

        mUncalledStudents.add(new Student(R.string.aamir_ali, R.drawable.aamir_ali, "Aamir Ali"));
        mUncalledStudents.add(new Student(R.string.alex_aney, R.drawable.alex_aney, "Alex Aney"));
        mUncalledStudents.add(new Student(R.string.bipra_dey, R.drawable.bipra_dey, "Bipra Dey"));
        mUncalledStudents.add(new Student(R.string.daniel_dultsin, R.drawable.daniel_dultsin, "Daniel Dulstin"));
        mUncalledStudents.add(new Student(R.string.darren_dong, R.drawable.darren_dong, "Darren Dong"));
        mUncalledStudents.add(new Student(R.string.dennis_wang, R.drawable.dennis_wang, "Dennis Wang"));
        mUncalledStudents.add(new Student(R.string.dhruv_amin, R.drawable.dhruv_amin, "Dhruv Amin"));
        mUncalledStudents.add(new Student(R.string.eden_kodan, R.drawable.eden_kogan, "Eden Kodan"));
        mUncalledStudents.add(new Student(R.string.eli_bui, R.drawable.eli_bui, "Eli Bui"));
        mUncalledStudents.add(new Student(R.string.elie_belkin, R.drawable.elie_belkin, "Elie Belkin"));
        mUncalledStudents.add(new Student(R.string.evelyn_paskhaver, R.drawable.evelyn_paskhaver, "Evelyn Paskhaver"));
        mUncalledStudents.add(new Student(R.string.fardin_iqbal, R.drawable.fardin_iqbal, "Fardin Iqbal"));
        mUncalledStudents.add(new Student(R.string.jerry_he, R.drawable.jerry_he, "Jerry He"));
        mUncalledStudents.add(new Student(R.string.kenny_cao, R.drawable.kenny_cao, "Kenny Cao"));
        mUncalledStudents.add(new Student(R.string.marc_rosenberg, R.drawable.marc_rosenberg, "Marc Rosenberg"));
        mUncalledStudents.add(new Student(R.string.matthew_chen, R.drawable.matthew_chen, "Matthew Chen"));
        mUncalledStudents.add(new Student(R.string.michael_wu, R.drawable.michael_wu, "Micheal Wu"));
        mUncalledStudents.add(new Student(R.string.ming_lin, R.drawable.ming_lin, "Ming Lin"));
        mUncalledStudents.add(new Student(R.string.mohammed_ihtisham, R.drawable.mohammed_ihtisham, "Mohammed Ihtisham"));
        mUncalledStudents.add(new Student(R.string.noam_canter, R.drawable.noam_canter, "Noam Canter"));
        mUncalledStudents.add(new Student(R.string.ralf_pacia, R.drawable.ralf_pacia, "Ralf Pacia"));
        mUncalledStudents.add(new Student(R.string.samuel_iskhakov, R.drawable.samuel_iskhakov, "Samuel Iskhakov"));
        mUncalledStudents.add(new Student(R.string.sean_kerrigan, R.drawable.sean_kerrigan, "Seam Kierrigan"));
        mUncalledStudents.add(new Student(R.string.sebastian_marinescu, R.drawable.sebastian_marinescu, "Sebasian Marinescu"));
        mUncalledStudents.add(new Student(R.string.selina_li, R.drawable.selina_li, "Selina Li"));
        mUncalledStudents.add(new Student(R.string.shuyue_chen, R.drawable.shuyue_chen, "Shuyue Chen"));
        mUncalledStudents.add(new Student(R.string.tanushri_sundaram, R.drawable.tanushri_sundaram, "Tanushri Sundaram"));
        mUncalledStudents.add(new Student(R.string.vasu_patel, R.drawable.vasu_patel, "Vasu Patel"));
        mUncalledStudents.add(new Student(R.string.xinrui_ge, R.drawable.xinrui_ge, "Xinrui Ge"));
        mUncalledStudents.add(new Student(R.string.zhian_maysoon, R.drawable.zhian_maysoon, "Zhian Maysoon"));

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
        currentStudent = mAllStudents.get((int) (Math.random() * mAllStudents.size()));
        while (currentStudent.getCallTracker() >= 2) {
//            ArrayList<Student> possibleStudent = new ArrayList<>();
            currentStudent = mAllStudents.get((int) (Math.random() * mAllStudents.size()));

        }
        currentStudent.addToLastDateAndTimeCalled(getCurrentTime());
        currentStudent.setCallTracker(currentStudent.getCallTracker() + 1);
        mCalledLog.add(currentStudent);
        if (!mCalledLog.contains(currentStudent)) {
            mCalledLog.add(currentStudent);
        }
        if (currentStudent.getCallTracker() >= 2) {
            mAllStudents.remove(currentStudent);
        }
        if (currentStudent.getCallTracker() >= 1) {
            mUncalledStudents.remove(currentStudent);
        }
    }
}
