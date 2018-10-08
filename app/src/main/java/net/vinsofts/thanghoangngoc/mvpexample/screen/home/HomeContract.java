package net.vinsofts.thanghoangngoc.mvpexample.screen.home;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BasePresenter;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BaseView;

import java.util.List;

public interface HomeContract {
    interface View extends BaseView {
        void onGetListBooksSuccess(List<Book> books);

        void onGetListBooksFailed(String msg);

        void insertBookResponse(boolean status);

        Context getContext();
    }

    interface Presenter extends BasePresenter<View> {
        void getListBooks();

        void insertBook();
    }
}
