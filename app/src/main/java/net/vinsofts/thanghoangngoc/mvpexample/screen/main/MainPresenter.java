package net.vinsofts.thanghoangngoc.mvpexample.screen.main;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.BookRepository;
import net.vinsofts.thanghoangngoc.mvpexample.data.UserDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.UserRepository;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, UserDataSource.OnFetchDataListener<User> {
    private static final String TAG = MainPresenter.class.getName();
    private MainContract.View mMainView;
    private UserRepository mUserRepository;

    MainPresenter() {

    }

    @Override
    public void setView(MainContract.View view) {
        mMainView = view;
        Context context = view.getContext();
        this.mUserRepository = UserRepository.getInstance(context);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        this.mMainView = null;
    }

    @Override
    public void getListUsers(String url, Context context) {
        if (mMainView == null) return;
        mUserRepository.getListUsers(this, url, context);
    }

    @Override
    public void onFetchDataSuccess(List<User> data) {
        if (mMainView == null) return;
        mMainView.onGetListUsersSuccess(data);
    }

    @Override
    public void onFetchDataFailure(String error) {
        if (mMainView == null) return;
        mMainView.onGetListUsersFailed(error);
    }
}
