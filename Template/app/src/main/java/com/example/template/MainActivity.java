package com.example.template;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements LeQuangDuy_Adapter.ClickListener{

    private Button btnUpdate,btnDelete,btnAdd;

    RecyclerView recyclerView;
    LeQuangDuy_Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    private SearchView searchView;


    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        aSwitch = (Switch) findViewById(R.id.row_switch);

        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        layoutManager = new GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(myAdapter);


        myAdapter = new LeQuangDuy_Adapter(this, Application.list);

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

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(v->{

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("HI");
            alert.setMessage("Xóa tất cả mục đã chọn ?");
            alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    LinkedList<Table_LeQuangDuy> toRemove = new LinkedList<>();

                    for (Table_LeQuangDuy i: Application.list){
                        if (i.isColumnBoolean() == 1){
                            toRemove.add(i);
                        }
                    }

                    LeQuangDuy_sqlite db = new LeQuangDuy_sqlite(MainActivity.this );

                    for (Table_LeQuangDuy i:toRemove){
                        db.delete(i.getColumnInt());
                    }

//                    Application.list.removeAll(toRemove);

                    myAdapter.notifyDataSetChanged();

                }
//                    if (toRemove.size()>0){
//
//                }
            });

            alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // close dialog
                    dialog.cancel();
                }
            });
            alert.show();
//            AlertDialog.
        });


        btnAdd.setOnClickListener(e->{
            final Intent intent = new Intent(this, Add.class);

            startActivityForResult(intent, 1);
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