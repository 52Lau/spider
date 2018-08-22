package com.lau.spider.model;

import java.util.Date;
import javax.persistence.*;

public class Content {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联素材id
     */
    private Integer contextid;

    /**
     * 类型1--YouTube、2---music
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 预发布内容
     */
    private String context;

    /**
     * 创建修改时间
     */
    private Date createdate;

    /**
     * 状态0正常 1禁用
     */
    private Integer status;

    private  Integer issend;

    public Integer getIssend() {
        return issend;
    }

    public void setIssend(Integer issend) {
        this.issend = issend;
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
     * 获取关联素材id
     *
     * @return contextid - 关联素材id
     */
    public Integer getContextid() {
        return contextid;
    }

    /**
     * 设置关联素材id
     *
     * @param contextid 关联素材id
     */
    public void setContextid(Integer contextid) {
        this.contextid = contextid;
    }

    /**
     * 获取类型1--YouTube、2---music
     *
     * @return typeId - 类型1--YouTube、2---music
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置类型1--YouTube、2---music
     *
     * @param typeid 类型1--YouTube、2---music
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取预发布内容
     *
     * @return context - 预发布内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置预发布内容
     *
     * @param context 预发布内容
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 获取创建修改时间
     *
     * @return createdate - 创建修改时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建修改时间
     *
     * @param createdate 创建修改时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取状态0正常 1禁用
     *
     * @return status - 状态0正常 1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0正常 1禁用
     *
     * @param status 状态0正常 1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}