package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MYDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key, name text, address text, email text);");
        sqLiteDatabase.execSQL("CREATE TABLE Books(id integer primary key, title text, " +
                "id_author integer not null constraint id_author references Author(id) ON DELETE CASCADE ON UPDATE CASCADE);");
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }
    public int insertAuthor(Author author){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", author.getIdAuthor());
        content.put("name", author.getName());
        content.put("address", author.getAddress());
        content.put("email", author.getEmail());
        int res = (int) db.insert("Authors", null, content);
        return res;
    }

    public ArrayList<Author> getAll(){
        ArrayList<Author> list = new ArrayList<>();
        String sql="select* from Authors";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3) ));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    public Author getAuthorId(int id){
        Author author = null;
        String sql = "select * from Authors where id = "+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                author =new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3) );
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return author;
    }

    public int insertBook(Book book){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", book.getId());
        content.put("title", book.getTitle());
        content.put("id_author", book.getIdAuthor());
        int res = (int) db.insert("Books", null, content);
        return res;
    }
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        String sql="select * from Books";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    public Book getBookId(int id){
        Book book = null;
        String sql = "select * from Books where id = "+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                book =new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return book;
    }


}
