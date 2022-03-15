package com.example.cs2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String ht = getIntent().getExtras().getString("ht");
        String ns = getIntent().getExtras().getString("ns");

        TextView tv_KetQua = findViewById(R.id.textView_KetQua);

        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int tuoi = year - Integer.parseInt(ns);
        tv_KetQua.setText("Họ và Tên: " + ht +"\n"+ "Sinh Năm: " +ns+ "\n"+"Tuổi: " +tuoi);
    }
}