package com.example.cs1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_HsA = findViewById(R.id.editText_HeSoA);
        EditText ed_HsB = findViewById(R.id.editText_HeSoB);

        Button btn_Tong = findViewById(R.id.btn_Tong);
        Button btn_Hieu = findViewById(R.id.btn_Hieu);
        Button btn_Tich = findViewById(R.id.btn_Tich);
        Button btn_Thuong = findViewById(R.id.btn_Thuong);

        TextView tv_KetQua = findViewById(R.id.textView_KetQua);

        btn_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(ed_HsA.getText().toString());
                int b= Integer.parseInt(ed_HsB.getText().toString());
                int sum = a+b;

                tv_KetQua.setText("Kết Quả: " + sum);
            }
        });

        btn_Hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(ed_HsA.getText().toString());
                int b= Integer.parseInt(ed_HsB.getText().toString());
                int sum = a-b;

                tv_KetQua.setText("Kết Quả: " + sum);
            }
        });

        btn_Tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(ed_HsA.getText().toString());
                int b= Integer.parseInt(ed_HsB.getText().toString());
                int sum = a*b;

                tv_KetQua.setText("Kết Quả: " + sum);
            }
        });

        btn_Thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(ed_HsA.getText().toString());
                int b= Integer.parseInt(ed_HsB.getText().toString());
                double sum = a*1.0/b;

                tv_KetQua.setText("Kết Quả: " + sum);
            }
        });
    }
}