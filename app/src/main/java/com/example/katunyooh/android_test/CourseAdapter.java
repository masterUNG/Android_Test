package com.example.katunyooh.android_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 4/10/2017 AD.
 */

public class CourseAdapter extends BaseAdapter{

    private Context context;
    private String[] subjectStrings, descripStrings;

    public CourseAdapter(Context context,
                         String[] subjectStrings,
                         String[] descripStrings) {
        this.context = context;
        this.subjectStrings = subjectStrings;
        this.descripStrings = descripStrings;
    }

    @Override
    public int getCount() {
        return subjectStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.course_listview, viewGroup, false);

        //For Subject
        TextView subjectTextView = (TextView) view1.findViewById(R.id.txtSubject);
        subjectTextView.setText(subjectStrings[i]);

        //For Descrip
        TextView descripTextView = (TextView) view1.findViewById(R.id.txtDescrip);
        descripTextView.setText(descripStrings[i]);

        return view1;
    }
}   // Main Class
