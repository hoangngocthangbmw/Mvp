package net.vinsofts.thanghoangngoc.mvpexample.screen.main;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import net.vinsofts.thanghoangngoc.mvpexample.R;
import net.vinsofts.thanghoangngoc.mvpexample.data.UserRepository;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;
import net.vinsofts.thanghoangngoc.mvpexample.screen.BaseActivity;
import net.vinsofts.thanghoangngoc.mvpexample.screen.home.HomeActivity;
import net.vinsofts.thanghoangngoc.mvpexample.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.button)
    Button button;
    private MainContract.Presenter mPresenter;

    @Override
    protected void initData() {
        mPresenter.getListUsers(Constant.BASE_URL, MainActivity.this);
    }

    @Override
    protected void initView() {
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onGetListUsersSuccess(List<User> users) {
        textName.setText("");
        for (User user : users) {
            textName.append(user.getName() + " " + user.getEmail() + " \n ");
        }
    }

    @Override
    public void onGetListUsersFailed(String message) {
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        openActivity(HomeActivity.class);
    }
}
