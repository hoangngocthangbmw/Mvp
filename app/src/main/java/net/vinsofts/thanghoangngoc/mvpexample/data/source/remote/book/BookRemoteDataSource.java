package net.vinsofts.thanghoangngoc.mvpexample.data.source.remote.book;

import net.vinsofts.thanghoangngoc.mvpexample.data.BookDataSource;

public class BookRemoteDataSource implements BookDataSource.RemoteDataSource {

    private static BookRemoteDataSource sBookRemoteDataSource;

    private BookRemoteDataSource() {

    }

    public static BookRemoteDataSource getInstance() {
        if (null == sBookRemoteDataSource) {
            sBookRemoteDataSource = new BookRemoteDataSource();
        }
        return sBookRemoteDataSource;
    }

}
