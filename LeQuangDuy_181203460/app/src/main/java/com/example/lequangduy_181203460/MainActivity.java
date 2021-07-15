package com.example.lequangduy_181203460;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Switch;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements Adapter_181203460.ClickListener{

    private Button btnUpdate,btnDelete,btnAdd;

    RecyclerView recyclerView;
    Adapter_181203460 myAdapter;
    RecyclerView.LayoutManager layoutManager;

    private SearchView searchView;

    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        myAdapter = new Adapter_181203460(this, Application.list);

        recyclerView.setAdapter(myAdapter);

        searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                System.out.println("Text Submit ======> " + query);
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                System.out.println("Text Change======> " + query);
                myAdapter.getFilter().filter(query);
                return false;
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {

            if(resultCode == Activity.RESULT_OK) {
                myAdapter.notifyDataSetChanged();
                System.out.println("Change");
            } else {

            }
        }
    }

    @Override
    public void setOnClickListener(int position) {
        Intent intent = new Intent(this,Detail.class);
        intent.putExtra("id", position);

        startActivity(intent);

    }

    @Override
    public void setOnLong(int position) {

    }

}