package com.example.custom_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView_DT = findViewById(R.id.gridView_DienThoai);

        List<DienThoai> listPhone = new SetData().setDataDefault();

        DienThoaiAdapter dienThoaiAdapter = new DienThoaiAdapter(MainActivity.this, listPhone);
        gridView_DT.setAdapter(dienThoaiAdapter);


        gridView_DT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("duy "+  i);

                Intent intent = new Intent(MainActivity.this, MainActivityCT.class);
                intent.putExtra("index", i);
                System.out.println("duy "+  i);
                startActivity(intent);
            }
        });
    }




}