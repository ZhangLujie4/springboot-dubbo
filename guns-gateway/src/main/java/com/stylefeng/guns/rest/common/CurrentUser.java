package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.core.api.UserInfoModel;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 16:05
 * @description
 */
public class CurrentUser {

//    // 线程绑定的存储空间
//    private static final ThreadLocal<UserInfoModel> threadLocal = new ThreadLocal<>();
//
//    // 将用户信息放入存储空间
//    public static void saveUserInfo(UserInfoModel userInfoModel) {
//        threadLocal.set(userInfoModel);
//    }
//
//    // 将用户信息取出
//    public static UserInfoModel getCurrentUser() {
//        return threadLocal.get();
//    }

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserId(String userId) {
        threadLocal.set(userId);
    }

    public static String getCurrentUser() {
        return threadLocal.get();
    }
}