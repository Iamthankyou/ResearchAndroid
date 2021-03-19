package com.example.recycleviewwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ClickListener{

    private EditText etName,etPhone;
    private TextView tvName,tvPhone;
    private Button btnAdd;
    private ItemFragment itemFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etPhone= (EditText) findViewById(R.id.etPhone);
        tvName  = (TextView) findViewById(R.id.tvName);
        tvPhone  = (TextView) findViewById(R.id.tvPhone);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        itemFragment = (ItemFragment) fragmentManager.findFragmentById(R.id.itemFragment);

        btnAdd.setOnClickListener(v -> {
            if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Plese enter full feild", Toast.LENGTH_SHORT).show();
            }
            else{
                Application.listPerson.add(new Person(etName.getText().toString(),etPhone.getText().toString()));
                Toast.makeText(MainActivity.this,"Person successfully added", Toast.LENGTH_SHORT).show();
                etName.setText(null);
                etPhone.setText(null);

                itemFragment.setChangeNotify();
            }
        });

    }

    @Override
    public void setOnClickListener(int position) {
        tvName.setText(Application.listPerson.get(position).getName());
        tvPhone.setText(Application.listPerson.get(position).getPhone());
    }
}