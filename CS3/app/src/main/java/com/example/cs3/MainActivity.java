package com.example.cs3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView tv_KQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_KQ = findViewById(R.id.textView_KetQua);
        Button bt_TT = findViewById(R.id.btn_NhapThongTin);

        bt_TT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, 9999);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK){
            String ht = data.getStringExtra("ht").toString();
            String ns = data.getStringExtra("ns").toString();
            Calendar calendar = Calendar.getInstance();
            int age = calendar.get(Calendar.YEAR) - Integer.parseInt(ns);
            tv_KQ.setText("Họ và Tên: " +ht+"\nNăm Sinh: " +ns+"\nTuổi: "+age);
        }
    }
}