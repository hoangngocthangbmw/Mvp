package net.vinsofts.thanghoangngoc.mvpexample.data;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;
import net.vinsofts.thanghoangngoc.mvpexample.data.source.local.book.BookLocalDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.source.remote.book.BookRemoteDataSource;

public class BookRepository implements BookDataSource.LocalDataSource, BookDataSource.RemoteDataSource {
    private static BookRepository sBookRepository;
    private BookDataSource.RemoteDataSource mRemoteDataSource;
    private BookDataSource.LocalDataSource mLocalDataSource;

    private BookRepository(BookDataSource.RemoteDataSource remoteDataSource, BookDataSource.LocalDataSource localDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    public static BookRepository getInstance(Context context) {
        if (null == sBookRepository) {
            sBookRepository = new BookRepository(BookRemoteDataSource.getInstance(), BookLocalDataSource.getInstance(context));
        }
        return sBookRepository;
    }

    @Override
    public void getListBooks(BookDataSource.OnFetchDataListener<Book> listener) {
        mLocalDataSource.getListBooks(listener);
    }

    @Override
    public void insertBook(BookDataSource.OnFetchDataListener<Book> listener) {
        mLocalDataSource.insertBook(listener);
    }
}
