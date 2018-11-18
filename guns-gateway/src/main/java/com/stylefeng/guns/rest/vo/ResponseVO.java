package com.stylefeng.guns.rest.vo;

import lombok.Data;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-11-15 15:52
 * @description
 */
@Data
public class ResponseVO<T> {

    // 返回状态码
    private Integer status;

    // 返回信息
    private String msg;

    private String imgPre;

    // 返回数据实体
    private T data;

    public static<T> ResponseVO success(String imgPre, T t) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(t);
        responseVO.setImgPre(imgPre);

        return responseVO;
    }

    public static<T> ResponseVO success(T t) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(t);

        return responseVO;
    }

    public static<T> ResponseVO success(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static<T> ResponseVO serviceFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static<T> ResponseVO appFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }
}
