package top.kongwen.biz.iml;

import top.kongwen.bean.User;
import top.kongwen.biz.OnLoginListener;
import top.kongwen.biz.IUserBiz;

/**
 * Created by PEO on 2018/7/5.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("kw".equals(username) && "123456".equals(password)){
                    User user = new User(username, password);
                    listener.loginSuccess(user);
                } else {
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
