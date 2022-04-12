package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivityInfor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_infor);


        Intent intent = getIntent();
        DienThoai phone = (DienThoai) intent.getSerializableExtra("phone");

        FragmentInfor fragmentInfor = (FragmentInfor) getFragmentManager().findFragmentById(R.id.fragmentInfor2);
        if(fragmentInfor != null)
            fragmentInfor.setData(phone);

    }
}