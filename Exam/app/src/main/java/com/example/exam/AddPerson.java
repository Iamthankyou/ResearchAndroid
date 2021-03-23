package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPerson extends AppCompatActivity {

    private Button btnAdd;
    private EditText etName,etClass,etId,etBirthday;
    private List listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        etName = (EditText) findViewById(R.id.etAddName);
        etId = (EditText) findViewById(R.id.etAddId);

        btnAdd.setOnClickListener(e->{
            if (etName.getText().toString().isEmpty()  || etId.getText().toString().isEmpty()){
                Toast.makeText(this,"Vui lòng điền tất cả thông tin",Toast.LENGTH_SHORT).show();
            }
            else{
                MyDbHelper db = new MyDbHelper(this);

//                if (db.getStudent(etId.getText()){
//                    Toast.makeText(this, "Số điện thoại đã đăng ký", Toast.LENGTH_SHORT).show();
//                }
//                else{
                    db.addStudent(new Student(etName.getText().toString(),etId.getText().toString()));
//                    Toast.makeText(this, "Số điện thoại đã đăng ký", Toast.LENGTH_SHORT).show();

                    listFragment.setChangeNotify();
                    Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);

//                }
            }
        });
    }
}