package net.vinsofts.thanghoangngoc.mvpexample.screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.vinsofts.thanghoangngoc.mvpexample.utils.Utils;
import net.vinsofts.thanghoangngoc.mvpexample.widget.LoadingDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected Activity mActivity;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        this.mActivity = this;
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    public void openActivity(Class<? extends Activity> clazz) {
        openActivity(clazz, null);
    }

    public void openActivity(Class<? extends Activity> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected Fragment getCurrentFragment(int resId) {
        return getSupportFragmentManager().findFragmentById(resId);
    }

    protected void replaceFragmentImmediate(Fragment fragment, int resId) {
        if (fragment == null) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(resId, fragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                View v = getCurrentFocus();
                if (v instanceof EditText) {
                    int[] location = new int[2];
                    v.getLocationOnScreen(location);

                    int right = v.getWidth() + location[0];
                    int bottom = v.getHeight() + location[1];

                    if (ev.getX() < location[0] || ev.getX() > right
                            || ev.getY() < location[1] || ev.getY() > bottom) {
                        Utils.hideKeyboard(mActivity, (EditText) v);
                    }
                }
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

    protected void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    protected void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(mActivity);
        }

        loadingDialog.show();
    }

    protected void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}