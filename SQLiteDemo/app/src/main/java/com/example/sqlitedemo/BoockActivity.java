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

public class BoockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boock);

        EditText ed_Id = findViewById(R.id.id_Book);
        EditText ed_Title = findViewById(R.id.id_Title);
        EditText ed_Author_Book = findViewById(R.id.id_Author_Book);

        GridView gridViewListBook = findViewById(R.id.gridViewListBook);

        DBHelper dbHelper = new DBHelper(this);

        Button btn_Save = findViewById(R.id.id_Save_Book);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book(Integer.parseInt(ed_Id.getText().toString()), ed_Title.getText().toString(), Integer.parseInt(ed_Author_Book.getText().toString()));
                if (dbHelper.insertBook(book) > 0)
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu không thành công", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_Select = findViewById(R.id.id_Select_Book);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> list_Book;
                ArrayList<String> stringArrayList = new ArrayList<>();
                if(!ed_Id.getText().toString().trim().equals("")){
                    Book book = dbHelper.getBookId(Integer.parseInt(ed_Id.getText().toString().trim()));
                    if(book != null){
                        stringArrayList.add(String.valueOf(book.getId()));
                        stringArrayList.add(book.getTitle());
                        stringArrayList.add(String.valueOf(book.getIdAuthor()));
                    }else
                        Toast.makeText(getApplicationContext(), "Không tim thây", Toast.LENGTH_SHORT).show();

                }else{
                    list_Book = dbHelper.getAllBook();
                    for(Book book : list_Book){
                        stringArrayList.add(String.valueOf(book.getId()));
                        stringArrayList.add(book.getTitle());
                        stringArrayList.add(String.valueOf(book.getIdAuthor()));
                    }
                }

                ArrayAdapter adapter = new ArrayAdapter(BoockActivity.this, android.R.layout.simple_list_item_1, stringArrayList);
                gridViewListBook.setAdapter(adapter);
            }
        });

    }
}