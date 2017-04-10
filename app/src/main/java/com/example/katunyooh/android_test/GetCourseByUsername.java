package com.example.katunyooh.android_test;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by BOY on 10/4/2560.
 */

public class GetCourseByUsername extends AsyncTask<String,Void,String>{
    private Context context;

    public GetCourseByUsername(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("Uname" ,params[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[1]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        }catch (Exception e){
            Log.d("10AprilV2", "e doIn ==> " + e.toString());
            return null;
        }


    }
} // Main Class
