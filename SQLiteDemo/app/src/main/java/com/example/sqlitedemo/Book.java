package com.example.sqlitedemo;

public class Book {
    private int id;
    private String title;
    private int idAuthor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Book(int id, String title, int idAuthor) {
        this.id = id;
        this.title = title;
        this.idAuthor = idAuthor;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idAuthor=" + idAuthor +
                '}';
    }
}
