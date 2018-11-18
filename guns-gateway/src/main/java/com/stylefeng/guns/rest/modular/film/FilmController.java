package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.api.film.FilmServiceApi;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-16 16:13
 * @description
 */

@RestController
@RequestMapping("/film/")
public class FilmController {

    /**
     * api网关：
     * 1、功能聚合【api聚合】
     * 好处：
     *  1、6个接口一次请求，同一时刻节省五次http请求
     *  2、同一接口对外暴露，降低了前后端开发的难度和复杂度
     * 坏处：
     *  1、以此换取数据过多容易出现问题
     * @return
     */

    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    // 获取首页信息接口
    @RequestMapping(value = "getIndex", method = RequestMethod.GET)
    public ResponseVO getIndex() {

        FilmIndexVO filmIndexVO = new FilmIndexVO();
        // 获取banner
        filmIndexVO.setBanners(filmServiceApi.getBanners());

        // 获取正在热映
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true, 8));

        // 获取即将上映
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true, 8));

        // 票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());

        // 获取受欢迎的榜单
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());

        // 获取前一百
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(filmIndexVO);
    }


}
