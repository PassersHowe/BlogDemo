package com.passershowe.blogdemo.mvp.data.source.remote;

import android.support.annotation.NonNull;

import com.passershowe.blogdemo.mvp.data.source.BooksDataSource;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public class BooksRemoteDataSource implements BooksDataSource{

    private static  BooksRemoteDataSource INSTANCE;


    public static BooksRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BooksRemoteDataSource();
        }
        return INSTANCE;
    }

    private BooksRemoteDataSource(){}


    @Override
    public void getBooks(@NonNull LoadBooksCallback loadBooksCallback) {

    }
}
