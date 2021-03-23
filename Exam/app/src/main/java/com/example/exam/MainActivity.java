package com.example.exam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements StudentAdapter.ClickListener {

    private EditText etDetailName,etDetailId;
    private CircleImageView imgAvatar;
    private Fragment detailFragment,taskbarFragment,addFragment;
    private List listFragment;
    private FragmentManager fragmentManager;
    private Button btnUpdate,btnDelete,btnHomeAdd,btnHomeDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDetailName = (EditText) findViewById(R.id.etAddName);
        etDetailId = (EditText) findViewById(R.id.etAddId);
        btnUpdate = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        imgAvatar = (CircleImageView) findViewById(R.id.ivAddAvatar);
        btnHomeAdd = (Button) findViewById(R.id.btnHomeAdd);
        btnHomeDelete = (Button) findViewById(R.id.btnHomeDelete);

        fragmentManager = this.getSupportFragmentManager();
        listFragment = (List) fragmentManager.findFragmentById(R.id.listFragment);
        detailFragment = (Detail) fragmentManager.findFragmentById(R.id.detailFragment);
        taskbarFragment = (TaskbarFragment) fragmentManager.findFragmentById(R.id.taskbarFragment);
//        addFragment = (AddStudent) fragmentManager.findFragmentById(R.id.addFragment);

        fragmentManager.beginTransaction()
                .show(listFragment)
                .hide(detailFragment)
                .show(taskbarFragment)
                .commit();

        btnHomeDelete.setOnClickListener(v->{

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("HI");
            alert.setMessage("Xóa tất cả mục đã chọn ?");
            alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    LinkedList<Student> toRemove = new LinkedList<>();

                    for (Student i: Application.listStudent){
                        if (i.isSelected()){
                            toRemove.add(i);
                        }
                    }

                    MyDbHelper db = new MyDbHelper(MainActivity.this );

                    for (Student i:toRemove){
                        db.deleteStudent(i.getId());
                    }

                    if (toRemove.size()>0){
                        Application.listStudent.removeAll(toRemove);
                    }
                    listFragment.setChangeNotify();

                }
            });
            alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // close dialog
                    dialog.cancel();
                }
            });
            alert.show();
//            AlertDialog.
        });

        btnHomeAdd.setOnClickListener(v->{
            Intent intent = new Intent(this,AddPerson.class);
            startActivity(intent);
        });

        btnUpdate.setOnClickListener(e-> {
            if (etDetailName.getText().toString().isEmpty() || etDetailId.getText().toString().isEmpty() ){
                Toast.makeText(this,"Vui lòng điền tất cả thông tin",Toast.LENGTH_SHORT).show();
            }
            else {

                MyDbHelper db = new MyDbHelper(this);
                db.deleteStudent(etDetailId.getText().toString());
                db.addStudent(new Student(etDetailName.getText().toString(), etDetailId.getText().toString()));
//                db.updateStudent();

                listFragment.setChangeNotify();

                fragmentManager.beginTransaction()
                        .show(listFragment)
                        .hide(detailFragment)
                        .show(taskbarFragment)
                        .commit();

            }
        });

        btnDelete.setOnClickListener(e->{
            MyDbHelper db = new MyDbHelper(this);
            db.deleteStudent(etDetailId.getText().toString());
            listFragment.setChangeNotify();
        });
    }

    @Override
    public void setOnClickListener(int position) {
        etDetailName.setText(Application.listStudent.get(position).getName());
        etDetailId.setText(Application.listStudent.get(position).getId());


        fragmentManager.beginTransaction()
                .hide(listFragment)
                .show(detailFragment)
                .hide(taskbarFragment)
                .addToBackStack(null)
                .commit();

    }
}