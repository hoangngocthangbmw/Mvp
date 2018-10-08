package net.vinsofts.thanghoangngoc.mvpexample.screen;

public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();

    void onDestroy();
}
