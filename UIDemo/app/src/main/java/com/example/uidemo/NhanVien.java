package com.example.uidemo;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

public class NhanVien {
    private int maNV;
    private String name;
    private String gioiTinh;
    private String donVi;
    private Bitmap img;

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public NhanVien(int maNV, String name, String gioiTinh, String donVi) {
        this.maNV = maNV;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
    }

    public NhanVien(int maNV, String name, String gioiTinh, String donVi, Bitmap img) {
        this.maNV = maNV;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.img = img;
    }

    public NhanVien() {
    }

//    @Override
//    public String toString() {
//        return "NhanVien{"+
//                img + ","+
//                maNV +
//                ","  + name  +
//                "," + gioiTinh  +
//                ","  + donVi  +
//
//                "}";
//    }
}
