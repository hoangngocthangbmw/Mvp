package net.vinsofts.thanghoangngoc.mvpexample.screen.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Book>> users;

    public LiveData<List<Book>> getBooks() {
        if (users == null) {
            users = new MutableLiveData<List<Book>>();
            users.setValue(loadUsers());
        }
        return users;
    }

    private List<Book> loadUsers() {
        List<Book> list = new ArrayList<>();

        return list;
    }
}