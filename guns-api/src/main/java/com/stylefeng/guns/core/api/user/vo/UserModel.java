package com.stylefeng.guns.core.api.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 15:31
 * @description
 */

@Data
public class UserModel implements Serializable {

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    public String getUsername() {
        return username;
    }
}
