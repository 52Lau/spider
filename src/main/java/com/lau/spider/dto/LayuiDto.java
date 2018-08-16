package com.lau.spider.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @program: LayuiDto
 * @description: Layui返回数据封装工具类
 * @author: Lau52y
 * @create: 2018-08-13 23:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Data
public class LayuiDto {
    /**
     * 状态码（成功0 失败其他）
     */
    @Builder.Default
    private int code=0;
    /**
     * 错误提示
     */
    private String msg="";
    /**
     * 总数（分页）
     */
    private int count;
    /**
     * 返回实体对象的集合
     */
    private Object[] data;
}
