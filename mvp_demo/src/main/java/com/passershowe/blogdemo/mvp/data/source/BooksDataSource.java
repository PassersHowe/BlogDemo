package com.passershowe.blogdemo.mvp.data.source;

import android.support.annotation.NonNull;

import com.passershowe.blogdemo.mvp.data.bean.Book;

import java.util.List;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public interface BooksDataSource {

    interface LoadBooksCallback{
        void loadBooks(List<Book> bookList);
        void dataNotAvailable();
    }

    void getBooks(@NonNull LoadBooksCallback loadBooksCallback);
}
