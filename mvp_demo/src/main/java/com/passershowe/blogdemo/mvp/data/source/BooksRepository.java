package com.passershowe.blogdemo.mvp.data.source;

import android.support.annotation.NonNull;

import com.passershowe.blogdemo.mvp.data.bean.Book;
import com.passershowe.blogdemo.mvp.data.source.local.BooksLocalDataSource;
import com.passershowe.blogdemo.mvp.data.source.remote.BooksRemoteDataSource;

import java.util.List;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public class BooksRepository implements BooksDataSource{

    private static BooksRepository INSTANCE = null;
    
    private final BooksDataSource mBooksRemoteDataSource;

    private final BooksDataSource mBooksLocalDataSource;
    
    private BooksRepository(@NonNull BooksDataSource booksRemoteDataSource,
                            @NonNull BooksDataSource booksLocalDataSource) {
        mBooksRemoteDataSource = booksRemoteDataSource;
        mBooksLocalDataSource = booksLocalDataSource;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    public static BooksRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BooksRepository(BooksRemoteDataSource.getInstance(), BooksLocalDataSource.getInstance());
        }
        return INSTANCE;
    }


    @Override
    public void getBooks(@NonNull final LoadBooksCallback loadBooksCallback) {
        //数据回调
        mBooksLocalDataSource.getBooks(new LoadBooksCallback() {
            @Override
            public void loadBooks(List<Book> bookList) {
                loadBooksCallback.loadBooks(bookList);
            }

            @Override
            public void dataNotAvailable() {
                loadBooksCallback.dataNotAvailable();
            }
        });
    }

}

