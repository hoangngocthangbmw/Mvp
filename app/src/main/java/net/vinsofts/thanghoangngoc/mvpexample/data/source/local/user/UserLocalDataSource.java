package net.vinsofts.thanghoangngoc.mvpexample.data.source.local.user;

import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.UserDataSource;


public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private static UserLocalDataSource sUserLocalDataSource;

    private UserLocalDataSource(Context context) {

    }

    public static UserLocalDataSource getInstance(Context context) {
        if (null == sUserLocalDataSource) {
            sUserLocalDataSource = new UserLocalDataSource(context);
        }
        return sUserLocalDataSource;
    }
}
