package com.example.giaipt;

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

        EditText ed_HSA = findViewById(R.id.edit_HSA);
        EditText ed_HSB = findViewById(R.id.edit_HSB);
        EditText ed_HSC = findViewById(R.id.edit_HSC);

        Button btn_submit = findViewById(R.id.btn_Submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                double x, y, z;
                try {
                    x=Double.parseDouble(ed_HSA.getText().toString());
                } catch (NumberFormatException ex) {

                    return;
                }
                try {
                    y=Double.parseDouble(ed_HSB.getText().toString());
                } catch(NumberFormatException ex) {

                    return;
                }
                try {
                    z=Double.parseDouble(ed_HSC.getText().toString());
                } catch(NumberFormatException ex) {

                    return;
                }
                GiaiPT pt = new GiaiPT();
                String kq= pt.ptb2(x, y, z);

                intent.putExtra("kq", kq);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}