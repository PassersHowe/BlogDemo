package com.passershowe.blogdemo.mvp.data.source.local;

import android.support.annotation.NonNull;

import com.passershowe.blogdemo.mvp.data.bean.Book;
import com.passershowe.blogdemo.mvp.data.source.BooksDataSource;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by PassersHowe on 2017/4/25.
 */

public class BooksLocalDataSource implements BooksDataSource{

    private static BooksLocalDataSource INSTANCE;


    public static BooksLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BooksLocalDataSource();
        }
        return INSTANCE;
    }

    private BooksLocalDataSource(){}

    @Override
    public void getBooks(@NonNull LoadBooksCallback loadBooksCallback) {
        //模拟数据
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1,"《第一行代码：Android (第2版) 》","郭霖","编程");
        Book book2 = new Book(2,"《Android开发艺术探索》","任玉刚","编程");
        Book book3 = new Book(3,"《Android群英传》","徐宜生","编程");
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        loadBooksCallback.loadBooks(bookList);

    }
}
