package net.vinsofts.thanghoangngoc.mvpexample.data;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;

import java.util.List;

public interface UserDataSource {
    interface LocalDataSource {

    }

    interface RemoteDataSource {
        void getListUsers(OnFetchDataListener<User> listener, String url, Context context);
    }

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(String error);
    }
}
