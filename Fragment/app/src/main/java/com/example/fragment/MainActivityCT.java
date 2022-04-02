package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityCT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ct);

        ImageView imageView = findViewById(R.id.image_DT2);
        TextView tvDetail = findViewById(R.id.title_DT2);
        TextView tvPriceDetail = findViewById(R.id.price_DT2);
        TextView tvCt = findViewById(R.id.tv_ct);
        Intent intent = getIntent();
        int index = intent.getIntExtra("index" ,0);
        DienThoai dt = new SetData().setDataDefault().get(index);

        imageView.setImageResource(dt.getImage());
        tvDetail.setText(dt.getName());
        tvPriceDetail.setText(dt.getPrice()+" VND");
        tvCt.setText(dt.getCt());
    }
}