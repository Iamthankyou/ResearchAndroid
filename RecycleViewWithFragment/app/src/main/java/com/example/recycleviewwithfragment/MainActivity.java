package com.example.recycleviewwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ClickListener{

    private EditText etName,etPhone;
    private TextView tvName,tvPhone;
    private Button btnAdd,btnFragAdd,btnFragShow;
    private Fragment detailFragment, buttonFrag, addFrag;
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
        btnFragAdd = (Button) findViewById(R.id.btnFragAdd);
        btnFragShow = (Button) findViewById(R.id.btnFragShow);

        fragmentManager = this.getSupportFragmentManager();
        itemFragment = (ItemFragment) fragmentManager.findFragmentById(R.id.itemFragment);
        detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.detailFragment);
        buttonFrag = (FragmentButton) fragmentManager.findFragmentById(R.id.fragButton);
        addFrag = (AddPersonFragment) fragmentManager.findFragmentById(R.id.addPersonFragment);

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

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(addFrag)
                .show(itemFragment)
                .hide(detailFragment)
                .commit();

        btnFragAdd.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(addFrag)
                .show(itemFragment)
                .hide(detailFragment)
                .commit();
        });

        btnFragShow.setOnClickListener(v->{
            fragmentManager.beginTransaction()
                    .show(buttonFrag)
                    .hide(addFrag)
                    .show(itemFragment)
                    .show(detailFragment)
                    .commit();
        });

    }

    @Override
    public void setOnClickListener(int position) {
        tvName.setText(Application.listPerson.get(position).getName());
        tvPhone.setText(Application.listPerson.get(position).getPhone());
    }
}