package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Item.ItemSelected {

    private TextView tvDescription;
    private String [] descriptions;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.textView);

        descriptions = getResources().getStringArray(R.array.descriptions);

        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.item))
                    .hide(fragmentManager.findFragmentById(R.id.detail))
                    .commit();
        }

        if (findViewById(R.id.layout_land) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.item))
                    .show(fragmentManager.findFragmentById(R.id.detail))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int id) {
        tvDescription.setText(descriptions[id]);

        if (findViewById(R.id.layout_land) != null){
            tvDescription.setText(descriptions[0]);
        }

        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            fragmentManager.beginTransaction()
                        .show(fragmentManager.findFragmentById(R.id.detail))
                        .hide(fragmentManager.findFragmentById(R.id.item))
                        .addToBackStack(null)
                        .commit();
        }
    }
}















