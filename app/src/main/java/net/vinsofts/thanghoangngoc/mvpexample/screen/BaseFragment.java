package net.vinsofts.thanghoangngoc.mvpexample.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.vinsofts.thanghoangngoc.mvpexample.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    private Unbinder unbinder;
    private LoadingDialog loadingDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, v);
        initView(v);
        return v;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dismissDialogLoading();
        if (unbinder != null)
            unbinder.unbind();
    }

    public void replaceFragment(BaseFragment fragment, Bundle mBundle) {
        FragmentTransaction fragmentTransaction =
                getChildFragmentManager().beginTransaction();
        fragment.setArguments(mBundle);
        fragmentTransaction.replace(getContainerId(), fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public int getContainerId() {
        return 0;
    }

    protected void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    protected void showDialogLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(mActivity);
        }

        loadingDialog.show();
    }

    protected void dismissDialogLoading() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
