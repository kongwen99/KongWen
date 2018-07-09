package top.kongwen.biz;

import top.kongwen.bean.User;

/**
 * Created by PEO on 2018/7/5.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();

}
