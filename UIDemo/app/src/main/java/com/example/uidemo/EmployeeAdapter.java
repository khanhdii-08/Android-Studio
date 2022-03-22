package com.example.uidemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NhanVien> listNV;
    Uri uri;
    Bitmap bitmap ;

    public EmployeeAdapter(Context context, int layout, List<NhanVien> listNV) {
        this.context = context;
        this.layout = layout;
        this.listNV = listNV;
    }

    @Override
    public int getCount() {
        return listNV.size();
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
        view = inflater.inflate(layout,null);
        TextView txtID = (TextView) view.findViewById(R.id.tv_ma);
        TextView txtName = (TextView) view.findViewById(R.id.tv_ten);
        TextView txtSex = (TextView) view.findViewById(R.id.tv_gt);
        TextView txtPB = (TextView) view.findViewById(R.id.tv_ban);
        ImageView img = (ImageView) view.findViewById(R.id.img_lv);
        NhanVien nv = listNV.get(i);
        txtID.setText("Mã NV: "+nv.getMaNV());
        txtName.setText("Tên: "+nv.getName().toString());
        txtSex.setText("giới tính: "+nv.getGioiTinh().toString());
        txtPB.setText("Đơn vị: "+nv.getDonVi().toString());
        //img.setImageResource(R.drawable.sp01);
        img.setImageBitmap(nv.getImg());

        return view;
    }
}
