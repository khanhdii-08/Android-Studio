package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentInfor extends Fragment {

    ImageView imageView;
    TextView tvDetail;
    TextView tvPrice;
    TextView tvCt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infor, container, false);

        imageView = view.findViewById(R.id.image_DT_infor);
        tvDetail = view.findViewById(R.id.title_DT_infor);
        tvPrice = view.findViewById(R.id.price_DT_infor);
        tvCt = view.findViewById(R.id.tv_ct_infor);

        return view;
    }

    public void setData(DienThoai dienThoai){
        imageView.setImageResource(dienThoai.getImage());
        tvDetail.setText(dienThoai.getName());
        tvPrice.setText(dienThoai.getPrice()+" VND");
        tvCt.setText(dienThoai.getCt());
    }
}
