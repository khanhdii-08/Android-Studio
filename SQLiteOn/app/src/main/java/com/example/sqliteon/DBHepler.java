package com.example.sqliteon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHepler extends SQLiteOpenHelper {
    public DBHepler(@Nullable Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PhongBan(id integer primary key, ten text);");
        sqLiteDatabase.execSQL("CREATE TABLE NhanVien(id integer primary key, ten text, ngaysinh text, id_pb integer not null " +
                "constraint id_pb references PhongBan(id) ON DELETE CASCADE ON UPDATE CASCADE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PhongBan");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NhanVien");
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    public boolean insertPB(PhongBan phongBan){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", phongBan.getId_PB());
        content.put("ten", phongBan.getTen_PB());
        int n = (int) db.insert("PhongBan", null, content);
        return  n>0;
    }

    public List<PhongBan> getAllPhongBan(){
        List<PhongBan> list = new ArrayList<PhongBan>();
        String sql = "select * from PhongBan";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new PhongBan(cursor.getInt(0), cursor.getString(1)));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }
        return list;
    }

    public boolean insertNV(NhanVien nhanVien){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", nhanVien.getId());
        content.put("ten", nhanVien.getTen());
        content.put("ngaysinh", nhanVien.getNgaySinh());
        content.put("id_pb", nhanVien.getId_PB());
        int n = (int) db.insert("NhanVien", null, content);
        return  n>0;
    }

    public NhanVien getNhanVien(int id){
        NhanVien nhanVien = null;
        String sql = "select * from NhanVien where id=" + id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                nhanVien = new NhanVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }
        return nhanVien;
    }

}
