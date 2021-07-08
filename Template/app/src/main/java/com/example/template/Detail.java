package com.example.template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    private EditText etDId, etDString, etDDouble;
    private Button btnDUpdate, btnDBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etDId = (EditText) findViewById(R.id.etDInt);
        etDString = (EditText) findViewById(R.id.etDString);
        etDDouble = (EditText) findViewById(R.id.etDDouble);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        etDId.setText(String.valueOf(Application.list.get(id).getColumnInt()));
        etDString.setText(String.valueOf(Application.list.get(id).getColumnString()));
        etDDouble.setText(String.valueOf(Application.list.get(id).getColumnDouble()));

        btnDUpdate = (Button) findViewById(R.id.btnDUpdate);
        btnDBack = (Button) findViewById(R.id.btnDBack);

        btnDUpdate.setOnClickListener(e->{
            System.out.println("====>> Check update");

            if (etDId.getText().toString().trim().length()>0 && etDString.getText().toString().trim().length()>0 && etDDouble.getText().toString().trim().length()>0){
                LeQuangDuy_sqlite db = new LeQuangDuy_sqlite(this);
                db.update(new Table_LeQuangDuy(Integer.parseInt(etDId.getText().toString()), etDString.getText().toString(), Double.parseDouble(etDDouble.getText().toString()), 0));
            }
            else{
                Toast.makeText(this,"Vui lòng điền tất cả thông tin",Toast.LENGTH_SHORT).show();
            }
        });

        btnDBack.setOnClickListener(e->{
            Intent intentt = new Intent(getApplicationContext(), MainActivity.class);
            intentt.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentt);
        });
    }
}