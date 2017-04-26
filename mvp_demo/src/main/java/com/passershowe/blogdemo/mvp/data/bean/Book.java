package com.passershowe.blogdemo.mvp.data.bean;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public class Book {

    private int book_id;
    private String book_name;
    private String book_author;
    private String book_tag;

    public Book() {
    }

    public Book(int book_id, String book_name, String book_author, String book_tag) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_tag = book_tag;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_tag() {
        return book_tag;
    }

    public void setBook_tag(String book_tag) {
        this.book_tag = book_tag;
    }
}
