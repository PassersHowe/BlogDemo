package com.passershowe.blogdemo.mvp.ui.book;

import com.passershowe.blogdemo.mvp.data.bean.Book;
import com.passershowe.blogdemo.mvp.ui.base.BasePresenter;
import com.passershowe.blogdemo.mvp.ui.base.BaseView;

import java.util.List;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public interface BooksContract {

    interface View extends BaseView<Presenter>{
        void showBookList(List<Book> bookList);
        void showNoBooks();

    }

    interface Presenter extends BasePresenter{
        void loadBooks();
    }


}
