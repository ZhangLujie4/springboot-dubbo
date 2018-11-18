package com.stylefeng.guns.core.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:23
 * @description
 */

@Data
public class BannerVO implements Serializable {

    private String bannerId;

    private String bannerAddress;

    private String bannerUrl;
}
