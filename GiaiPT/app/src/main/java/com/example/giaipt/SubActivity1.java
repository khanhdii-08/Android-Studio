package com.example.giaipt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        EditText ed_HSA = findViewById(R.id.edit_HSA1);
        EditText ed_HSB = findViewById(R.id.edit_HSB1);

        Button btn_Submit = findViewById(R.id.btn_Submit1);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                double a, b;
                try {
                    a = Double.parseDouble(ed_HSA.getText().toString());
                    b = Double.parseDouble(ed_HSB.getText().toString());
                }catch (Exception e){

                    return;
                }

                GiaiPT pt = new GiaiPT();
                String kq =  pt.ptb1(a,b);
                intent.putExtra("kq", kq);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}