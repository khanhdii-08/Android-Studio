package com.example.uidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<NhanVien> nvList;

    public NhanVienAdapter(Context context, int layout, List<NhanVien> nvList) {
        this.context = context;
        this.layout = layout;
        this.nvList = nvList;
    }

    @Override
    public int getCount() {
        return nvList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView textViewMa = view.findViewById(R.id.tv_ma);
        TextView textViewTen = view.findViewById(R.id.tv_ten);
        TextView textViewGT = view.findViewById(R.id.tv_gt);
        TextView textViewPhong = view.findViewById(R.id.tv_phong);
        ImageView imageView = view.findViewById(R.id.img_nv_custom);

        NhanVien nv = nvList.get(i);
        textViewMa.setText(nv.getMaso()+"");
        textViewTen.setText(nv.getHoten());
        textViewGT.setText(nv.getGioiTinh());
        textViewPhong.setText(nv.getDonVi());
        imageView.setImageBitmap(nv.getBitmap());


        return view;
    }
}
