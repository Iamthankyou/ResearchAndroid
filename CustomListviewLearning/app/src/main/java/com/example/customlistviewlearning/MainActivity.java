package com.example.customlistviewlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        listProduct = new ArrayList<>();
        listProduct.add(new Product(true,"laptop","laptop","1000","This laptop is strongest in the world, you might buy it now"));
        listProduct.add(new Product(false,"hdd","laptop","500","This hdd is strongest in the world, you might buy it now"));
        listProduct.add(new Product(true,"memory","laptop","1000","memory laptop is strongest in the world, you might buy it now"));

        ProductAdapter adapter = new ProductAdapter(this,R.layout.row_layout,listProduct);
        listView.setAdapter(adapter);
    }
}