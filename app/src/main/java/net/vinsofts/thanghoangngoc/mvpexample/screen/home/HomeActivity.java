package net.vinsofts.thanghoangngoc.mvpexample.screen.home;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.vinsofts.thanghoangngoc.mvpexample.R;
import net.vinsofts.thanghoangngoc.mvpexample.data.BookRepository;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private static final String TAG = HomeActivity.class.getName();
    @BindView(R.id.btnInsert)
    Button btnInsert;
    @BindView(R.id.btnShow)
    Button btnShow;
    @BindView(R.id.txtReponse)
    TextView txtReponse;
    private HomeContract.Presenter mPresenter;
    private List<Book> mBooks = new ArrayList<>();

    @Override
    protected void initData() {
        mPresenter.getListBooks();
    }

    @Override
    protected void initView() {
        mPresenter = new HomePresenter();
        mPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onGetListBooksSuccess(List<Book> books) {
        this.mBooks = books;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fetchData();
            }
        });
    }

    private void fetchData() {
        txtReponse.setText("");
        for (Book book : mBooks) {
            txtReponse.append(book.getName() + "-" + book.getAuthor() + "\n");
        }
    }

    @Override
    public void onGetListBooksFailed(String msg) {
        showToast(msg);
    }

    @Override
    public void insertBookResponse(boolean status) {
        if (status == true) {
            mPresenter.getListBooks();
        }
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @OnClick({R.id.btnInsert, R.id.btnShow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnInsert:
                mPresenter.insertBook();
                break;
            case R.id.btnShow:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
