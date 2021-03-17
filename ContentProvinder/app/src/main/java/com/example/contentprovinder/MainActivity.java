package com.example.contentprovinder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contentprovinder.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnSubmit;
    private ContentResolver resolver;
    private ArrayList<String> listName,listNumber;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNumber = new ArrayList<>();

        listView = (ListView)findViewById(R.id.listView);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(e->{
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},1);
            }

            listName = getAllContacts();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1,listName);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String number = (String) listNumber.get(position);
                    Toast.makeText(MainActivity.this,number,Toast.LENGTH_LONG).show();
                }
            });

//            resolver = getContentResolver();
////            Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.});
//
//            List<String> list = new ArrayList<>();
//
//            while (cursor.moveToNext()){
//                long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                Cursor c = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "= ?", new String[]{String.valueOf(id)},null);
//
//                String dt = "";
//
//                while (c.moveToNext()){
//                    dt+= c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))+". ";
//                }
//
//                list.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))+" ("+dt+")");
//            }
//
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
//            listView.setAdapter(adapter);
        });
    }

    private ArrayList<String> getAllContacts(){
        ArrayList<String> list = new ArrayList<>();
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        if ((cursor!=null? cursor.getCount():0)>0){
            while (cursor!=null && cursor.moveToNext()){
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                list.add(name);

                if (cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))>0){
                    Cursor pCur = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ " =?", new String[]{id},null);
                    while (pCur.moveToNext()){
                        String phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        listNumber.add(phoneNumber);
                    }

                    pCur.close();;
                }
            }
        }

        if (cursor != null){
            cursor.close();
        }

        return list;
    }
}