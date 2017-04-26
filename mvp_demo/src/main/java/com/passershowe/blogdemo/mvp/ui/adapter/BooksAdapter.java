package com.passershowe.blogdemo.mvp.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.passershowe.blogdemo.mvp.R;
import com.passershowe.blogdemo.mvp.data.bean.Book;

import java.util.List;

/**
 * Created by PassersHowe on 2017/4/25.
 */

public class BooksAdapter extends BaseAdapter {
    private List<Book> mBookList;
    private Context mContext;
    private LayoutInflater inflater;

    public BooksAdapter(Context context, List<Book> bookList) {
        inflater = LayoutInflater.from(context);
        mBookList = bookList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBookList.isEmpty() ? 0 : mBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return mBookList.get(position).getBook_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BookViewHolder bookViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.book_item, parent, false);
            bookViewHolder = new BookViewHolder();
            bookViewHolder.itemBookName = (TextView) convertView.findViewById(R.id.item_book_name);
            bookViewHolder.itemBookAuthor = (TextView) convertView.findViewById(R.id.item_book_author);
            bookViewHolder.itemBookTag = (TextView) convertView.findViewById(R.id.item_book_tag);
            convertView.setTag(bookViewHolder);
        } else {
            bookViewHolder = (BookViewHolder) convertView.getTag();
        }

        bookViewHolder.itemBookName.setText(mBookList.get(position).getBook_name());
        bookViewHolder.itemBookAuthor.setText(mBookList.get(position).getBook_author());
        bookViewHolder.itemBookTag.setText(mBookList.get(position).getBook_tag());

        return convertView;
    }


    public class BookViewHolder {
        private TextView itemBookName;
        private TextView itemBookAuthor;
        private TextView itemBookTag;


    }
}
