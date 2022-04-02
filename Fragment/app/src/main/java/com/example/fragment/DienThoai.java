package com.example.fragment;

public class DienThoai {
    private String name;
    private Integer image;
    private String price;
    private String ct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public DienThoai(String name, Integer image, String price, String ct) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.ct = ct;
    }

    public DienThoai() {
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", price='" + price + '\'' +
                ", ct='" + ct + '\'' +
                '}';
    }
}
