package com.example.katunyooh.android_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SubjectUserListView extends AppCompatActivity {

    //Explicit
    private String usernameString;
    private String tag = "10AprilV2";
    private String urlPHP = "https://ranking.studio/demo/app/courses.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_user_list_view);

        //Get Valute From Intent

        getValuteFromIntent();

        //Get Course

        getCourse();




    } //main Method

    private void getCourse() {
        try {

            GetCourseByUsername getCourseByUsername = new GetCourseByUsername(SubjectUserListView.this);
            getCourseByUsername.execute(usernameString,urlPHP);
            String strJSON = getCourseByUsername.get();
            Log.d(tag,"e getCourse ==>" + strJSON);


        }catch (Exception e)
        {
            Log.d(tag  ,"e getCourses ==>" + e.toString());
        }

    }// getCourses

    private void getValuteFromIntent() {
        usernameString = getIntent().getStringExtra("USERNAME");
        Log.d(tag,"username ==>" + usernameString);
    }


} //mainclass
