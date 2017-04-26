package com.passershowe.blogdemo.mvp.ui.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.passershowe.blogdemo.mvp.R;
import com.passershowe.blogdemo.mvp.data.bean.Book;
import com.passershowe.blogdemo.mvp.data.source.BooksRepository;
import com.passershowe.blogdemo.mvp.presenter.BooksPresenter;
import com.passershowe.blogdemo.mvp.ui.adapter.BooksAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BooksContract.View {

    private BooksContract.Presenter mPresenter;
    private Button showBooksBtn;
    private TextView noDataText;
    private ListView bookListView;
    private BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = new BooksPresenter(BooksRepository.getInstance(),this);
    }



    private void initView() {
        showBooksBtn = (Button) findViewById(R.id.show_books_btn);
        noDataText = (TextView) findViewById(R.id.no_data_text);
        bookListView = (ListView) findViewById(R.id.books_list_view);

        showBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadBooks();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setPresenter(BooksContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showBookList(List<Book> bookList) {
        if (!bookList.isEmpty()) {
            noDataText.setVisibility(View.INVISIBLE);
        }

        booksAdapter = new BooksAdapter(getApplicationContext(), bookList);
        bookListView.setAdapter(booksAdapter);
    }

    @Override
    public void showNoBooks() {
        noDataText.setVisibility(View.VISIBLE);

    }
}
