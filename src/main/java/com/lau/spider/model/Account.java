package com.lau.spider.model;

import javax.persistence.*;

public class Account {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 认证身份
     */
    private String idcard;

    /**
     * 所属人
     */
    @Column(name = "Owner")
    private String owner;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 平台
     */
    private Integer platform;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取认证身份
     *
     * @return idcard - 认证身份
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置认证身份
     *
     * @param idcard 认证身份
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取所属人
     *
     * @return Owner - 所属人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置所属人
     *
     * @param owner 所属人
     */
    public void setOwner(String owner) {
        this.owner = owner;
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

    /**
     * 获取平台
     *
     * @return platform - 平台
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 设置平台
     *
     * @param platform 平台
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
}