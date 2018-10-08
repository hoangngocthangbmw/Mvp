package net.vinsofts.thanghoangngoc.mvpexample.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import net.vinsofts.thanghoangngoc.mvpexample.R;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BaseDialog;


public class LoadingDialog extends BaseDialog {

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.FullScreenStyle);
    }

    @Override
    protected void initBeforeSetContentView() {
        super.initBeforeSetContentView();
        getWindow().setBackgroundDrawable(new ColorDrawable());
        setCancelable(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }
}
