package top.kongwen.view;

import top.kongwen.bean.User;

/**
 * Created by PEO on 2018/7/5.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
