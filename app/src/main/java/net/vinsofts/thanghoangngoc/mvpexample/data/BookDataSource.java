package net.vinsofts.thanghoangngoc.mvpexample.data;


import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;

import java.util.List;

public interface BookDataSource {
    interface LocalDataSource {
        void getListBooks(BookDataSource.OnFetchDataListener<Book> listener);

        void insertBook(BookDataSource.OnFetchDataListener<Book> listener);
    }

    interface RemoteDataSource {

    }

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(String error);

        void onInsertResponse(boolean status);
    }

}
