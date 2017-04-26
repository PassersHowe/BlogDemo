package com.passershowe.blogdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.passershowe.blogdemo.mvp.data.bean.Book;
import com.passershowe.blogdemo.mvp.data.source.BooksDataSource;
import com.passershowe.blogdemo.mvp.data.source.BooksRepository;
import com.passershowe.blogdemo.mvp.ui.book.BooksContract;

import java.util.List;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public class BooksPresenter implements BooksContract.Presenter {

    private BooksRepository mBooksRepository;

    private BooksContract.View mBookView;

    public BooksPresenter(@NonNull BooksRepository booksRepository,@NonNull BooksContract.View bookView){
        mBooksRepository = booksRepository;
        mBookView = bookView;
        mBookView.setPresenter(this);

    }

    @Override
    public void start() {

    }

    @Override
    public void loadBooks() {
        mBooksRepository.getBooks(new BooksDataSource.LoadBooksCallback() {
            @Override
            public void loadBooks(List<Book> bookList) {
                mBookView.showBookList(bookList);
            }

            @Override
            public void dataNotAvailable() {
                mBookView.showNoBooks();
            }
        });
    }


}
