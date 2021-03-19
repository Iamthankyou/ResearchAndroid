package com.example.floatinghintandautocompleteedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (AutoCompleteTextView) findViewById(R.id.etName);

        String[] suggest = {"abc", "abd", "abe"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_line_autocomplte,suggest);

        tvName.setAdapter(adapter);
        tvName.setThreshold(1);

    }
}