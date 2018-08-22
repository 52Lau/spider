package com.lau.spider.model;

import javax.persistence.*;

public class Category {
    /**
     * id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id
     */
    @Column(name = "`catid`")
    private Integer catid;

    /**
     * 分类名称
     */
    @Column(name = "`catname`")
    private String catname;

    /**
     * 类型1平台 2内容
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取类型1平台 2内容
     *
     * @return type - 类型1平台 2内容
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型1平台 2内容
     *
     * @param type 类型1平台 2内容
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}