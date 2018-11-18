package com.stylefeng.guns.core.api.film;

import com.stylefeng.guns.core.api.film.vo.BannerVO;
import com.stylefeng.guns.core.api.film.vo.FilmInfo;
import com.stylefeng.guns.core.api.film.vo.FilmVO;

import java.util.List;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:50
 * @description
 */
public interface FilmServiceApi {

    // 获取banners
    List<BannerVO> getBanners();

    // 获取热映影片
    FilmVO getHotFilms(boolean isLimit, int nums);

    // 获取即将上映影片的受欢迎程度做排序
    FilmVO getSoonFilms(boolean isLimit, int nums);

    // 获取票房排行榜
    List<FilmInfo> getBoxRanking();

    // 获取人气排行榜
    List<FilmInfo> getExpectRanking();

    // 获取top100
    List<FilmInfo> getTop();
}
