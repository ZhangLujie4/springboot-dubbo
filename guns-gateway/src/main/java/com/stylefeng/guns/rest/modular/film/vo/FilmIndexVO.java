package com.stylefeng.guns.rest.modular.film.vo;

import com.stylefeng.guns.core.api.film.vo.BannerVO;
import com.stylefeng.guns.core.api.film.vo.FilmInfo;
import com.stylefeng.guns.core.api.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:22
 * @description
 */

@Data
public class FilmIndexVO {

    private List<BannerVO> banners;

    private FilmVO hotFilms;

    private FilmVO soonFilms;

    private List<FilmInfo> boxRanking;

    private List<FilmInfo> expectRanking;

    private List<FilmInfo> top100;
}
