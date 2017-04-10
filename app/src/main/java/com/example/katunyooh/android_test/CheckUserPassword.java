package com.example.katunyooh.android_test;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import static android.R.string.ok;

/**
 * Created by BOY on 10/4/2560.
 */

public class CheckUserPassword extends AsyncTask<String,Void,String>{

    private Context context; // context คือ การส่งข้อมูล

    public CheckUserPassword(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("username",params[0])
                    .add("password",params[1])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string(); // body is body on php

        } catch (Exception e) {
            Log.d("10AprilV1","e doIn ==>"+ e.toString());
            return null;
        }


    }
}
