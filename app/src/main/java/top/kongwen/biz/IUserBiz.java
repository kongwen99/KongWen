package top.kongwen.biz;

/**
 * Created by PEO on 2018/7/5.
 */

public interface IUserBiz {

    void login(String username, String password, OnLoginListener listener);
}
