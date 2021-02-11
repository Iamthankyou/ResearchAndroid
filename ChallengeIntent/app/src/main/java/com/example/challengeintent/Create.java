package com.example.challengeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Create extends AppCompatActivity implements View.OnClickListener {

    private EditText etName,etPhone,etWeb,etLocation;
    private ImageView btnSad,btnNormal,btnHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etName = (EditText)findViewById(R.id.etName);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etLocation = (EditText)findViewById(R.id.etLocation);
        etWeb = (EditText)findViewById(R.id.etWeb);

        btnSad = (ImageView)findViewById(R.id.btnSad);
        btnNormal = (ImageView)findViewById(R.id.btnNormal);
        btnHappy = (ImageView)findViewById(R.id.btnHappy);

        btnSad.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnHappy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (etName.getText().toString().isEmpty()|| etPhone.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty()){
            Toast.makeText(this,"Please fill all feilds",Toast.LENGTH_LONG);
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name",etName.getText().toString());
            intent.putExtra("location",etLocation.getText().toString());
            intent.putExtra("web",etWeb.getText().toString());
            intent.putExtra("phone",etPhone.getText().toString());

            if (v.getId() == R.id.btnSad){
                intent.putExtra("react","sad");
            }
            else if (v.getId() == R.id.btnNormal){
                intent.putExtra("react","normal");
            }
            else{
                intent.putExtra("react","happy");
            }

            setResult(RESULT_OK,intent);
            Create.this.finish();
        }
    }
}