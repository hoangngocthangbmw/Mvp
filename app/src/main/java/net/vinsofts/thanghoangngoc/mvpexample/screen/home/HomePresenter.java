package net.vinsofts.thanghoangngoc.mvpexample.screen.home;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.BookDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.BookRepository;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter, BookDataSource.OnFetchDataListener {
    private static final String TAG = HomePresenter.class.getName();
    private HomeContract.View mView;
    private BookRepository mBookRepository;

    HomePresenter() {
    }

    @Override
    public void setView(HomeContract.View view) {
        this.mView = view;
        Context context = view.getContext();
        this.mBookRepository = BookRepository.getInstance(context);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        this.mView = null;
    }

    @Override
    public void getListBooks() {
        if (mView == null) return;
        mBookRepository.getListBooks(this);
    }

    @Override
    public void onFetchDataSuccess(List data) {
        if (mView == null) return;
        mView.onGetListBooksSuccess(data);
    }

    @Override
    public void onFetchDataFailure(String error) {
        if (mView == null) return;
        mView.onGetListBooksFailed(error);
    }

    @Override
    public void insertBook() {
        if (mView == null) return;
        mBookRepository.insertBook(this);
    }

    @Override
    public void onInsertResponse(boolean status) {
        if (mView == null) return;
        mView.insertBookResponse(status);
    }

}
