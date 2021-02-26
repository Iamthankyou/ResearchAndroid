package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private ArrayList<Student> listStudent;

    StudentAdapter(Context context,int resources,ArrayList<Student> listStudent) {
        super(context,resources,listStudent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewStudent;

        viewStudent = convertView;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewStudent =  inflater.inflate(R.layout.activity_student_view, null);
        }

        Student student = (Student) getItem(position);

        if (student!=null){
            TextView tvId,tvName,tvYear;

            tvId = (TextView) viewStudent.findViewById(R.id.tvId);
            tvName = (TextView) viewStudent.findViewById(R.id.tvName);
            tvYear = (TextView) viewStudent.findViewById(R.id.tvYear);

            tvId.setText(String.format("ID = %d", student.getId()));
            tvName.setText(String.format("NAME : %s", student.getName()));
            tvYear.setText(String.format("YEAR %s", student.getYear()));

        }
        return viewStudent;
    }
}
