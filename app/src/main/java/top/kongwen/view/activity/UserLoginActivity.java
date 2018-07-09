package top.kongwen.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.kongwen.R;
import top.kongwen.bean.User;
import top.kongwen.common.BaseActivity;
import top.kongwen.presenter.UserLoginPresenter;
import top.kongwen.view.IUserLoginView;

/**
 * Created by PEO on 2018/7/6.
 */

public class UserLoginActivity extends BaseActivity implements IUserLoginView {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_clear)
    Button btnClear;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        toast(this, "to main activity");
    }

    @Override
    public void showFailedError() {
        toast(this, "error");
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                userLoginPresenter.login();
                break;
            case R.id.btn_clear:
                userLoginPresenter.clear();
                break;
        }
    }
}
