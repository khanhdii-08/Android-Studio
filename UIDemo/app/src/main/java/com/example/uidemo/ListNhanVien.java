package com.example.uidemo;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListNhanVien implements Serializable {
    ArrayList<NhanVien> listNV;

    public ListNhanVien(){
        listNV = new ArrayList<NhanVien>();
    }
    public ArrayList<NhanVien> getAllNhanVien(){
        return listNV;
    }
    public boolean addNhanVien(NhanVien nv){
        if(listNV.contains(nv))
            return false;

        listNV.add(nv);
        return true;
    }
    public NhanVien getNhanVien(int index){
        if(index <0 || index > listNV.size())
            return null;
        return listNV.get(index);
    }
    public int getSize(){
        return listNV.size();
    }
}
