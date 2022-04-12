package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText ed_Id = findViewById(R.id.id_Author);
        EditText ed_Name = findViewById(R.id.id_Name);
        EditText ed_Address = findViewById(R.id.id_Address);
        EditText ed_Email = findViewById(R.id.id_Email);
        GridView gridViewListAuthor = findViewById(R.id.gridViewListAuthor);
        DBHelper dbHelper = new DBHelper(this);

        Button btn_Save = findViewById(R.id.id_Save);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(ed_Id.getText().toString().trim()));
                author.setName(ed_Name.getText().toString().trim());
                author.setAddress(ed_Address.getText().toString().trim());
                author.setEmail(ed_Email.getText().toString().trim());
                if (dbHelper.insertAuthor(author) > 0)
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu không thành công", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_Select = findViewById(R.id.id_Select);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_Author;
                ArrayList<String> stringArrayList = new ArrayList<>();
                if(!ed_Id.getText().toString().trim().equals("")){
                    Author author = dbHelper.getAuthorId(Integer.parseInt(ed_Id.getText().toString().trim()));
                    if(author != null){
                        stringArrayList.add(String.valueOf(author.getIdAuthor()));
                        stringArrayList.add(author.getName());
                        stringArrayList.add(author.getAddress());
                        stringArrayList.add(author.getEmail());
                    }else
                        Toast.makeText(getApplicationContext(), "Không tim thây", Toast.LENGTH_SHORT).show();

                }else{
                    list_Author = dbHelper.getAll();
                    for(Author author : list_Author){
                        stringArrayList.add(String.valueOf(author.getIdAuthor()));
                        stringArrayList.add(author.getName());
                        stringArrayList.add(author.getAddress());
                        stringArrayList.add(author.getEmail());
                    }
                }

                ArrayAdapter adapter = new ArrayAdapter(AuthorActivity.this, android.R.layout.simple_list_item_1, stringArrayList);
                gridViewListAuthor.setAdapter(adapter);
            }
        });

    }
}