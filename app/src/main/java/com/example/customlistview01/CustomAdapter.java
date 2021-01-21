package com.example.customlistview01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        View view = convertView;

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_custom_list_view,null);
        }

        Student s = getItem(pos);

        if (s!=null){
            TextView tx1 = (TextView)view.findViewById(R.id.textView);
            TextView tx2 = (TextView)view.findViewById(R.id.birthday);
            tx1.setText(s.getName());
            tx2.setText(String.valueOf(s.getBirthday()));
        }

        return view;
    }
}
