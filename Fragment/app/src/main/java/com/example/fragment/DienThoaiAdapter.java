package com.example.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DienThoaiAdapter extends ArrayAdapter {
    Activity context;
    List<DienThoai> listPhone;
    public DienThoaiAdapter(@NonNull Activity context, List<DienThoai> listPhone) {
        super(context, R.layout.custom, listPhone);
        this.context = context;
        this.listPhone = listPhone;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View  view = inflater.inflate(R.layout.custom, null, false);

        ImageView imageView = view.findViewById(R.id.image_DT);
        TextView tvTitle = view.findViewById(R.id.title_DT);
        TextView tvPrice = view.findViewById(R.id.price_DT);

        imageView.setImageResource(listPhone.get(position).getImage());
        tvTitle.setText(listPhone.get(position).getName());
        tvPrice.setText(listPhone.get(position).getPrice()+" VND");

        return view;
    }

}
