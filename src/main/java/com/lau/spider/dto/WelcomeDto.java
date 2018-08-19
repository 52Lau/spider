package com.lau.spider.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @program: WelcomeDto
 * @description: WelcomeDto返回数据封装工具类
 * @author: Lau52y
 * @create: 2018-08-13 23:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Data
public class WelcomeDto {
    /**
     * 状态码（成功0 失败其他）
     */
    @Builder.Default
    private int code=200;
    @Builder.Default
    private int youtubeCount=0;
    @Builder.Default
    private int wishCount=0;
    @Builder.Default
    private int musicCount=0;
    @Builder.Default
    private int historyCount=0;
    /**
     * 返回实体对象的集合
     */
    private Object[] data;
}
