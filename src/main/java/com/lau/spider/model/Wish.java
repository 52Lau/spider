package com.lau.spider.model;

import java.util.Date;
import javax.persistence.*;

public class Wish {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 要求内容
     */
    private String context;

    /**
     * 状态
     */
    private Integer status;

    private Integer iscomplete;

    public Integer getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Integer iscomplete) {
        this.iscomplete = iscomplete;
    }

    /**
     * 创建修改时间
     */
    private Date createdate;

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
     * 获取要求内容
     *
     * @return context - 要求内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置要求内容
     *
     * @param context 要求内容
     */
    public void setContext(String context) {
        this.context = context;
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
}