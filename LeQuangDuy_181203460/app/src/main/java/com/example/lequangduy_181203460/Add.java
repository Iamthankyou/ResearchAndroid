package com.example.lequangduy_181203460;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {


    private EditText etSoXe, etQuangDuong, etDonGia, etKhuyenMai;
    private Button btnAAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etSoXe = (EditText) findViewById(R.id.etQuangDuong);
        etQuangDuong = (EditText) findViewById(R.id.etQuangDuong);
        etDonGia = (EditText) findViewById(R.id.etDonGia);
        etKhuyenMai = (EditText) findViewById(R.id.etKhuyenMai);


        btnAAdd = (Button) findViewById(R.id.btnAAdd);

        btnAAdd.setOnClickListener(e->{
            if (etSoXe.getText().toString().trim().length()>0 && etQuangDuong.getText().toString().trim().length()>0 && etDonGia.getText().toString().trim().length()>0){
                Sqlite_181203460 db = new Sqlite_181203460(this);
                db.add(new Taxi_LeQuangDuy(etSoXe.getText().toString(), Double.parseDouble(etQuangDuong.getText().toString()), Integer.parseInt(etDonGia.getText().toString()), Integer.parseInt(etKhuyenMai.getText().toString())));


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