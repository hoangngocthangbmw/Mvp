package net.vinsofts.thanghoangngoc.mvpexample.data.source.local.book;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.BookDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookLocalDataSource implements BookDataSource.LocalDataSource {
    private static BookLocalDataSource sBookLocalDataSource;
    private BookDatabase mBookDatabase;

    private BookLocalDataSource(Context context) {
        mBookDatabase = BookDatabase.getInstance(context);
    }

    public static BookLocalDataSource getInstance(Context context) {
        if (null == sBookLocalDataSource) {
            sBookLocalDataSource = new BookLocalDataSource(context);
        }
        return sBookLocalDataSource;
    }

    @Override
    public void getListBooks(BookDataSource.OnFetchDataListener<Book> listener) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                List<Book> mList = mBookDatabase.userDAO().getAllBooks();
                listener.onFetchDataSuccess(mList);
            }
        };
        thread.start();
    }

    @Override
    public void insertBook(BookDataSource.OnFetchDataListener<Book> listener) {
        Thread t = new Thread(mRunnable);
        t.start();
        listener.onInsertResponse(true);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mBookDatabase.userDAO().insert(
                    new Book("book" + new Random().nextInt(1000),
                            "athour" + new Random().nextInt(1000))
            );
        }
    };
}
