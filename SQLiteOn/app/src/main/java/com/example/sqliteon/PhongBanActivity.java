package com.example.sqliteon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhongBanActivity extends AppCompatActivity {
    EditText id;
    EditText ten;
    DBHepler dbHepler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        dbHepler = new DBHepler(this);

        id = findViewById(R.id.id_PB1);
        ten = findViewById(R.id.id_TenPB);

        Button btn_Save = findViewById(R.id.id_SavePB);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhongBan pb = new PhongBan(Integer.parseInt(id.getText().toString()), ten.getText().toString());
                if (dbHepler.insertPB(pb))
                    Toast.makeText(getApplicationContext(), "Save Thanh Cong ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Save Thanh Cong ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
