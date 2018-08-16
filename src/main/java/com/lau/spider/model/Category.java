package com.lau.spider.model;

import javax.persistence.*;

public class Category {
    /**
     * 分类id
     */
    @Id
    private Integer catid;

    /**
     * 分类名称
     */
    private String catname;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 获取分类id
     *
     * @return catid - 分类id
     */
    public Integer getCatid() {
        return catid;
    }

    /**
     * 设置分类id
     *
     * @param catid 分类id
     */
    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    /**
     * 获取分类名称
     *
     * @return catname - 分类名称
     */
    public String getCatname() {
        return catname;
    }

    /**
     * 设置分类名称
     *
     * @param catname 分类名称
     */
    public void setCatname(String catname) {
        this.catname = catname;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }
}