package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PushData{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        GridView gridView_DT = findViewById(R.id.gridView_DienThoai);
//
//        List<DienThoai> listPhone = new SetData().setDataDefault();
//
//        DienThoaiAdapter dienThoaiAdapter = new DienThoaiAdapter(this, listPhone);
//        gridView_DT.setAdapter(dienThoaiAdapter);
    }

    @Override
    public void dataPhone(DienThoai dienThoai) {
        FragmentInfor fragmentInfor = (FragmentInfor) getFragmentManager().findFragmentById(R.id.fragmentInfor);
        fragmentInfor.setData(dienThoai);

    }
}