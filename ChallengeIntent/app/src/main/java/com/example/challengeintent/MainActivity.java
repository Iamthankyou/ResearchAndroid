package com.example.challengeintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private ImageView btnReact, btnPhone, btnLocation, btnWeb;
    private int OK = 1;
    private String phone,location,web,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReact = (ImageView) findViewById(R.id.btnReact);
        btnPhone = (ImageView) findViewById(R.id.btnPhone);
        btnLocation = (ImageView) findViewById(R.id.btnLocation);
        btnWeb = (ImageView) findViewById(R.id.btnWeb);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnReact.setVisibility(View.GONE);
        btnPhone.setVisibility(View.GONE);
        btnLocation.setVisibility(View.GONE);
        btnWeb.setVisibility(View.GONE);

        btnPhone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
            startActivity(intent);
        });

        btnWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
            startActivity(intent);
        });

        btnLocation.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
            startActivity(intent);
        });


        btnSubmit.setOnClickListener(v -> {
                Intent intent= new Intent(MainActivity.this,Create.class);
                startActivityForResult(intent,OK);
            }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == OK){
            if (resultCode == RESULT_OK){
                btnReact.setVisibility(View.VISIBLE);
                btnPhone.setVisibility(View.VISIBLE);
                btnLocation.setVisibility(View.VISIBLE);
                btnWeb.setVisibility(View.VISIBLE);

                phone = data.getStringExtra("phone");
                name = data.getStringExtra("name");
                location = data.getStringExtra("location");
                web = data.getStringExtra("web");

            }
        }
    }
}