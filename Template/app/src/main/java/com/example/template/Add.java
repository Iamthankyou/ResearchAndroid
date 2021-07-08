package com.example.template;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    private EditText etAInt, etAString, etADouble;
    private Button btnAAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etAInt = (EditText) findViewById(R.id.etAInt);
        etAString = (EditText) findViewById(R.id.etAString);
        etADouble = (EditText) findViewById(R.id.etADouble);

        btnAAdd = (Button) findViewById(R.id.btnAAdd);

        btnAAdd.setOnClickListener(e->{
            if (etAInt.getText().toString().trim().length()>0 && etAString.getText().toString().trim().length()>0 && etADouble.getText().toString().trim().length()>0){
                LeQuangDuy_sqlite db = new LeQuangDuy_sqlite(this);
                db.add(new Table_LeQuangDuy(Integer.parseInt(etAInt.getText().toString()), etAString.getText().toString(), Double.parseDouble(etADouble.getText().toString()), 0));

                final Intent data = new Intent();

                setResult(Activity.RESULT_OK, data);

                finish();
            }
            else{
                Toast.makeText(this, "Bạn phải điền đầy đủ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}