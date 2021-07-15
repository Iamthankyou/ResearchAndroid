package com.example.lequangduy_181203460;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    private Button btnAdd, btnBack;
    private TextView tvDSoXe, tvDQuangDuong, tvDDonGia, tvDKhuyenMai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDSoXe = (TextView) findViewById(R.id.tvDSoXe);
        tvDQuangDuong = (TextView) findViewById(R.id.tvDQuangDuong);
        tvDDonGia = (TextView) findViewById(R.id.tvDDonGia);
        tvDKhuyenMai = (TextView)findViewById(R.id.tvDKhuyenMai);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        tvDSoXe.setText(String.valueOf(Application.list.get(id).getSoXe()));
        tvDQuangDuong.setText(String.valueOf(Application.list.get(id).getQuangDuong()));
        tvDDonGia.setText(String.valueOf(Application.list.get(id).getDonGia()));
        tvDKhuyenMai.setText(String.valueOf(Application.list.get(id).getKhuyenMai()));

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(e->{
            final Intent intentt = new Intent(this, Add.class);

            startActivity(intentt);

        });

        btnBack.setOnClickListener(e->{

        });
    }
}