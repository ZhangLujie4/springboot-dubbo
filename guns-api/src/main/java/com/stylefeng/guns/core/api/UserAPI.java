package com.stylefeng.guns.core.api;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 13:59
 * @description
 */
public interface UserAPI {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
