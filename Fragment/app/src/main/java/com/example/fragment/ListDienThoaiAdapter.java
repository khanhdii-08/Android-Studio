package com.example.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListDienThoaiAdapter extends ArrayAdapter {
    Activity context;
    List<DienThoai> listPhone;
    public ListDienThoaiAdapter(@NonNull Activity context, List<DienThoai> listPhone) {
        super(context, R.layout.row_custom, listPhone);
        this.context = context;
        this.listPhone = listPhone;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if (convertView == null)
            row = inflater.inflate(R.layout.row_custom, parent, false);

        ImageView imageView = row.findViewById(R.id.image_DT_list);
        TextView tv_title = row.findViewById(R.id.title_DT_list);
        TextView tv_price = row.findViewById(R.id.price_DT_list);

        DienThoai dt = listPhone.get(position);

        imageView.setImageResource(dt.getImage());
        tv_title.setText(dt.getName());
        tv_price.setText(dt.getPrice()+" VND");

        return row;
    }
}
