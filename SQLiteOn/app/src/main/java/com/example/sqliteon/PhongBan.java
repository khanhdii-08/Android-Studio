package com.example.sqliteon;

public class PhongBan {
    private int id_PB;

    public int getId_PB() {
        return id_PB;
    }

    public void setId_PB(int id_PB) {
        this.id_PB = id_PB;
    }

    public String getTen_PB() {
        return ten_PB;
    }

    public void setTen_PB(String ten_PB) {
        this.ten_PB = ten_PB;
    }

    private String ten_PB;

    public PhongBan(int id_PB, String ten_PB) {
        this.id_PB = id_PB;
        this.ten_PB = ten_PB;
    }

    public PhongBan() {
    }

    @Override
    public String toString() {
        return "PhongBan{" +
                "id_PB=" + id_PB +
                ", ten_PB='" + ten_PB + '\'' +
                '}';
    }
}
