package com.example.katunyooh.android_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ShowSubjectDetail extends AppCompatActivity {

    private String subjectString;
    private String tag = "10AprilV3";
    private String urlPHP = "https://ranking.studio/demo/app/getdetailsubject.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_subject_detail);

        //Get Value Intent
        getValueIntent();

        //Show Text
        showText();

    }   // Main Method

    private void showText() {

        try {

            GetDetailSubject getDetailSubject = new GetDetailSubject(ShowSubjectDetail.this);
            getDetailSubject.execute(subjectString, urlPHP);
            String strJSON = getDetailSubject.get();
            Log.d(tag, "JSON ==> " + strJSON);



        } catch (Exception e) {
            Log.d(tag, "e showText ==> " + e.toString());
        }

    }   // showText

    private void getValueIntent() {
        subjectString = getIntent().getStringExtra("Subject");
        Log.d(tag, "Subject ==> " + subjectString);
    }

}   // Main Class
