package com.example.uidemo;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class NhanVien implements Serializable {
    private int maso;
    private String hoten;
    private String gioiTinh;
    private String donVi;
    private Bitmap bitmap;

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public NhanVien(int maso, String hoten, String gioiTinh, String donVi, Bitmap bitmap) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.bitmap = bitmap;
    }

    public NhanVien(int maso) {
        this.maso = maso;
    }

    public NhanVien() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return maso == nhanVien.maso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maso);
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maso=" + maso +
                ", hoten='" + hoten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", donVi='" + donVi + '\'' +
                ", bitmap=" + bitmap +
                '}';
    }
}
