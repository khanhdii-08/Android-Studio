package com.example.cs3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText ed_HoTen = findViewById(R.id.edit_HoTen);
        EditText ed_NamSinh = findViewById(R.id.edit_NamSinh);

        Button btn_Submit = findViewById(R.id.btn_Submit);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ht", ed_HoTen.getText().toString());
                intent.putExtra("ns", ed_NamSinh.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}