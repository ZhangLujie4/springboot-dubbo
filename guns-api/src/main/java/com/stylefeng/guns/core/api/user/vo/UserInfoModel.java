package com.stylefeng.guns.core.api.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 15:34
 * @description
 */

@Data
public class UserInfoModel implements Serializable {

    private int uuid;

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private int sex;

    private String birthday;

    private int lifeState;

    private String biography;

    private String address;

    private String headAddress;

    private long createTime;

    private long updateTime;
}
