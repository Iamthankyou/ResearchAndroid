package com.example.practice1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SongAdapter.ClickListener{

    private Fragment topBarFragment;
    private ListFragment listFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = this.getSupportFragmentManager();
        listFragment = (ListFragment) fragmentManager.findFragmentById(R.id.list_fragment);
        topBarFragment = (TopBarFragment) fragmentManager.findFragmentById(R.id.top_bar_fragment);
        fragmentManager.beginTransaction()
                .show(listFragment)
                .show(topBarFragment)
                .commit();

    }

    @Override
    public void setOnClickListener(int position) {
        fragmentManager.beginTransaction()
                .hide(topBarFragment)
                .show(listFragment)
                .addToBackStack(null)
                .commit();

    }
}