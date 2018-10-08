package net.vinsofts.thanghoangngoc.mvpexample.data.source.remote.user;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.UserDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {

    private static UserRemoteDataSource sUserRemoteDataSource;

    private UserRemoteDataSource() {

    }

    public static UserRemoteDataSource getInstance() {
        if (null == sUserRemoteDataSource) {
            sUserRemoteDataSource = new UserRemoteDataSource();
        }
        return sUserRemoteDataSource;
    }

    @Override
    public void getListUsers(UserDataSource.OnFetchDataListener<User> listener, String url, Context context) {
        new GetUserAsynTask(listener).getListUsers(url, context);
    }
}
