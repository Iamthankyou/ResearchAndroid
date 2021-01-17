package com.example.sumtwonumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txNumOne,txNumTwo;
    private Button btnSumit;
    private TextView txSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txNumOne = (EditText)findViewById(R.id.txNumOne);
        txNumTwo = (EditText)findViewById(R.id.tdNumTwo);
        btnSumit = (Button)findViewById(R.id.button);
        txSum = (TextView)findViewById(R.id.textView);

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txSum.setText(String.valueOf(Integer.parseInt(txNumOne.toString())+Integer.parseInt(txNumTwo.toString())));
            }
        });
    }
}