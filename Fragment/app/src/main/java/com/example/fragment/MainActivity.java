package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PushData{

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView_DienThoai);
        int orientation  = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            gridView.setNumColumns(2);
        }
    }

    @Override
    public void dataPhone(DienThoai dienThoai) {
        FragmentInfor fragmentInfor = (FragmentInfor) getFragmentManager().findFragmentById(R.id.fragmentInfor);
        if(fragmentInfor != null)
            fragmentInfor.setData(dienThoai);
        else {
            Intent intent = new Intent(MainActivity.this, MainActivityInfor.class);
            intent.putExtra("phone", dienThoai);
            startActivity(intent);
        }

    }
}