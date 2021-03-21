package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements StudentAdapter.ClickListener {

    private EditText etDetailName,etDetailId,etDetailBirthday,etDetailClass;
    private CircleImageView imgAvatar;
    private Fragment detailFragment,taskbarFragment;
    private List listFragment;
    private FragmentManager fragmentManager;
    private Button btnUpdate,btnDelete,btnHomeAdd,btnHomeDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDetailName = (EditText) findViewById(R.id.etAddName);
        etDetailId = (EditText) findViewById(R.id.etAddId);
        etDetailBirthday = (EditText) findViewById(R.id.etAddBirthday);
        etDetailClass = (EditText) findViewById(R.id.etAddClass);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        imgAvatar = (CircleImageView) findViewById(R.id.ivAddAvatar);
//        btnHomeAdd = (Button) findViewById(R.id.)


        fragmentManager = this.getSupportFragmentManager();
        listFragment = (List) fragmentManager.findFragmentById(R.id.listFragment);
        detailFragment = (Detail) fragmentManager.findFragmentById(R.id.detailFragment);
        taskbarFragment = (TaskbarFragment) fragmentManager.findFragmentById(R.id.taskbarFragment);

        fragmentManager.beginTransaction()
                .show(listFragment)
                .hide(detailFragment)
                .show(taskbarFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setOnClickListener(int position) {
        etDetailName.setText(Application.listStudent.get(position).getName());
        etDetailId.setText(Application.listStudent.get(position).getId());
        etDetailClass.setText(Application.listStudent.get(position).getNameClass());
        etDetailBirthday.setText(Application.listStudent.get(position).getBirthday());


        fragmentManager.beginTransaction()
                .hide(listFragment)
                .show(detailFragment)
                .hide(taskbarFragment)
                .addToBackStack(null)
                .commit();

    }
}