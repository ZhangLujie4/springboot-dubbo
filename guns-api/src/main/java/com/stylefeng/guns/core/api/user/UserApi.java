package com.stylefeng.guns.core.api.user;

import com.stylefeng.guns.core.api.user.vo.UserInfoModel;
import com.stylefeng.guns.core.api.user.vo.UserModel;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 13:59
 * @description
 */
public interface UserApi {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
