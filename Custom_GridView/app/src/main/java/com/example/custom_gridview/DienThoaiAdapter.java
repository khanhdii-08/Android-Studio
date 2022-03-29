package com.example.custom_gridview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DienThoaiAdapter extends ArrayAdapter {
    Activity context;
    List<DienThoai> listPhone;

    public DienThoaiAdapter(@NonNull Activity context, List<DienThoai> listPhone) {
        super(context, R.layout.custom, listPhone);
        this.context = context;
        this.listPhone = listPhone;
    }

    public View getView(int i, View view , ViewGroup viewGroup){
        View row = view;
        LayoutInflater inflater = context.getLayoutInflater();
        if (view == null)
            row = inflater.inflate(R.layout.custom, null, false);

        ImageView imageView = row.findViewById(R.id.image_DT);
        TextView tvTitle = row.findViewById(R.id.title_DT);
        TextView tvPrice = row.findViewById(R.id.price_DT);
        Button buttonCT =  row.findViewById(R.id.btn_CT);

        buttonCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivityCT.class);
                intent.putExtra("index", i);
                System.out.println("duy "+  i);
                context.startActivity(intent);
            }
        });

        imageView.setImageResource(listPhone.get(i).getImage());
        tvTitle.setText(listPhone.get(i).getName());
        tvPrice.setText(listPhone.get(i).getPrice()+" VND");

        return row;
    }



}
