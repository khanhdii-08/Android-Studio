package com.example.cs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_HoTen =findViewById(R.id.editText_HoTen);
        EditText ed_NamSinh = findViewById(R.id.editText_NamSinh);
        Button bt_Submit = findViewById(R.id.btn_Submit);

        bt_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ht", ed_HoTen.getText().toString());
                intent.putExtra("ns", ed_NamSinh.getText().toString());
                startActivity(intent);
            }
        });
    }
}