package com.example.giaipt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_KQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Giai = findViewById(R.id.btn_Giai);
        Button btn_Giai1 = findViewById(R.id.btn_Giai1);
        tv_KQ = findViewById(R.id.textView_Kq);
        btn_Giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, 9999);
            }
        });

        btn_Giai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivityForResult(intent, 999);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK){
            String kq = data.getStringExtra("kq").toString();
            tv_KQ.setText("Kết Quả: "+kq);
        }else if(requestCode == 999 && resultCode == RESULT_OK){
            String kq = data.getStringExtra("kq").toString();
            tv_KQ.setText("Kết Quả: "+kq);
        }
    }

}