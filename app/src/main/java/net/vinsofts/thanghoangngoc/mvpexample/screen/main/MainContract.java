package net.vinsofts.thanghoangngoc.mvpexample.screen.main;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BasePresenter;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BaseView;

import java.util.List;

public interface MainContract {

    interface View extends BaseView {
        void onGetListUsersSuccess(List<User> users);

        void onGetListUsersFailed(String message);

        Context getContext();
    }

    interface Presenter extends BasePresenter<View> {
        void getListUsers(String url, Context context);
    }
}
