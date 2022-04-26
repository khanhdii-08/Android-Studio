package com.example.sqliteon;

public class NhanVien {
    private int id;
    private String ten;
    private String ngaySinh;
    private int id_PB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getId_PB() {
        return id_PB;
    }

    public void setId_PB(int id_PB) {
        this.id_PB = id_PB;
    }

    public NhanVien(int id, String ten, String ngaySinh, int id_PB) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.id_PB = id_PB;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", id_PB=" + id_PB +
                '}';
    }
}
