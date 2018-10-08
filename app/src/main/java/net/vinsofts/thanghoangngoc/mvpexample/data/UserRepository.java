package net.vinsofts.thanghoangngoc.mvpexample.data;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;
import net.vinsofts.thanghoangngoc.mvpexample.data.source.local.user.UserLocalDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.source.remote.user.UserRemoteDataSource;

public class UserRepository implements UserDataSource.RemoteDataSource, UserDataSource.LocalDataSource {
    private static UserRepository sUserRepository;
    private UserDataSource.RemoteDataSource mRemoteDataSource;
    private UserDataSource.LocalDataSource mLocalDataSource;

    private UserRepository(UserDataSource.RemoteDataSource remoteDataSource, UserDataSource.LocalDataSource localDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    public static UserRepository getInstance(Context context) {
        if (null == sUserRepository) {
            sUserRepository = new UserRepository(UserRemoteDataSource.getInstance(), UserLocalDataSource.getInstance(context));
        }
        return sUserRepository;
    }

    @Override
    public void getListUsers(UserDataSource.OnFetchDataListener<User> listener, String url, Context context) {
        mRemoteDataSource.getListUsers(listener, url, context);
    }

}
