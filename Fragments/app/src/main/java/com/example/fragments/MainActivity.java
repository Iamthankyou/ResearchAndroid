package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Item.ItemSelected {

    private TextView tvDescription;
    private ArrayList<String> descriptions;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.textView);

        descriptions = new ArrayList<>();

        descriptions.add("Line 1");
        descriptions.add("Line 2");
        descriptions.add("Line 3");

    }

    @Override
    public void onItemSelected(int id) {
        tvDescription.setText(descriptions.get(id));
    }
}