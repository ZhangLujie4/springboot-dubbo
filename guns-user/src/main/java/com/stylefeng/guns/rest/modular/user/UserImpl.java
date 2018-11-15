package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.api.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 13:59
 * @description
 */

@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI {

    @Override
    public boolean login(String userName, String password) {
        System.out.println("this is user service!!"+userName+","+password);
        return true;
    }
}
