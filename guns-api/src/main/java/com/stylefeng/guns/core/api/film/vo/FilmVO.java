package com.stylefeng.guns.core.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:28
 * @description
 */

@Data
public class FilmVO implements Serializable {

    private int filmNum;

    private List<FilmInfo> filmInfo;
}
