package com.stylefeng.guns.core.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:29
 * @description
 */
@Data
public class FilmInfo implements Serializable {

    private String filmId;

    private int filmType;

    private String imgAddress;

    private String filmName;

    private String filmScore;

    private int expectNum;

    private String showTime;

    private int boxNum;

    private String score;
}
