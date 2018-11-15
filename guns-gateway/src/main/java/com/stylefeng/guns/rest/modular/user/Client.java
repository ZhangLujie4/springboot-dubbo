package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.api.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 15:07
 * @description
 */

@Component
public class Client {


    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    public void run() {
        userAPI.login("admin", "password");
    }
}
