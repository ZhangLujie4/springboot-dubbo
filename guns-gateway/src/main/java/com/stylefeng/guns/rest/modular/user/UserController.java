package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.api.user.UserApi;
import com.stylefeng.guns.core.api.user.vo.UserInfoModel;
import com.stylefeng.guns.core.api.user.vo.UserModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 11:33
 * @description
 */

@RestController
@RequestMapping("/user/")
public class UserController {

    @Reference(interfaceClass = UserApi.class, check = false)
    private UserApi userAPI;

    @RequestMapping("register")
    public ResponseVO register(UserModel userModel) {

        if (StringUtils.isEmpty(userModel.getUsername())) {
            return ResponseVO.serviceFail("用户名不能为空");
        }

        if (StringUtils.isEmpty(userModel.getPassword())) {
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean isSuccess = userAPI.register(userModel);
        if (isSuccess) {
            return ResponseVO.success("注册成功");
        } else {
            return ResponseVO.serviceFail("注册失败");
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public ResponseVO check(String username) {

        if (StringUtils.isEmpty(username)) {
            return ResponseVO.serviceFail("用户名不能为空");
        } else {
            boolean notExist = userAPI.checkUsername(username);
            if (notExist) {
                return ResponseVO.success("用户名不存在");
            } else {
                return ResponseVO.serviceFail("用户名已存在");
            }
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResponseVO logout() {
        /**
         * 应用：
         * 1、前端存储jwt【7天】：jwt刷新
         * 2、服务端会存储活动用户的信息【30分钟】
         * 3、jwt里的useId为key,查找活跃用户
         *
         * 退出：
         * 1、前端会删除jwt
         * 2、后端服务器删除活跃用户缓存
         *
         * 现状：
         * 1、前端删除掉jwt
         */

        return ResponseVO.success("用户退出成功");
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ResponseVO getUserInfo() {

        String userId = CurrentUser.getCurrentUser();
        if (StringUtils.isNotEmpty(userId)) {
            UserInfoModel userInfoModel = userAPI.getUserInfo(Integer.valueOf(userId));
            if (userInfoModel != null) {
                return ResponseVO.success(userInfoModel);
            } else {
                return ResponseVO.appFail("用户信息查询失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {

        String userId = CurrentUser.getCurrentUser();
        if (StringUtils.isNotEmpty(userId)) {

            // 判断当前用户是否和修改相等
            if (Integer.parseInt(userId) != userInfoModel.getUuid()) {
                return ResponseVO.serviceFail("请修改您的个人信息");
            }
            UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);
            if (userInfoModel != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.appFail("用户信息修改失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }
}
