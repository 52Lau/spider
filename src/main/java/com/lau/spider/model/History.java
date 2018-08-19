package com.lau.spider.model;

import java.util.Date;
import javax.persistence.*;

public class History {
    /**
     * id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 匹配度
     */
    @Column(name = "`confidence`")
    private String confidence;

    /**
     * 第一层词义
     */
    @Column(name = "`level1`")
    private String level1;

    /**
     * 第二层词义
     */
    @Column(name = "`level2`")
    private String level2;

    /**
     * 分词
     */
    @Column(name = "`mention`")
    private String mention;

    /**
     * 百度百科url
     */
    @Column(name = "`bdbkUrl`")
    private String bdbkurl;

    /**
     * 词义描述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 创建时间
     */
    @Column(name = "`createDate`")
    private Date createdate;

    /**
     * 分析的描述
     */
    @Column(name = "`option`")
    private String option;

    /**
     * 百度百科id
     */
    @Column(name = "`bdbkKgId`")
    private String bdbkkgid;

    /**
     * 书名，比如：史记，宋史
     */
    @Column(name = "`bookName`")
    private String bookname;

    /**
     * 文章名，比如：夏本纪第二
     */
    @Column(name = "`articleName`")
    private String articlename;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`issend`")
    private Integer issend;

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
     * 获取匹配度
     *
     * @return confidence - 匹配度
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * 设置匹配度
     *
     * @param confidence 匹配度
     */
    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    /**
     * 获取第一层词义
     *
     * @return level1 - 第一层词义
     */
    public String getLevel1() {
        return level1;
    }

    /**
     * 设置第一层词义
     *
     * @param level1 第一层词义
     */
    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    /**
     * 获取第二层词义
     *
     * @return level2 - 第二层词义
     */
    public String getLevel2() {
        return level2;
    }

    /**
     * 设置第二层词义
     *
     * @param level2 第二层词义
     */
    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    /**
     * 获取分词
     *
     * @return mention - 分词
     */
    public String getMention() {
        return mention;
    }

    /**
     * 设置分词
     *
     * @param mention 分词
     */
    public void setMention(String mention) {
        this.mention = mention;
    }

    /**
     * 获取百度百科url
     *
     * @return bdbkUrl - 百度百科url
     */
    public String getBdbkurl() {
        return bdbkurl;
    }

    /**
     * 设置百度百科url
     *
     * @param bdbkurl 百度百科url
     */
    public void setBdbkurl(String bdbkurl) {
        this.bdbkurl = bdbkurl;
    }

    /**
     * 获取词义描述
     *
     * @return desc - 词义描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置词义描述
     *
     * @param desc 词义描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取分析的描述
     *
     * @return option - 分析的描述
     */
    public String getOption() {
        return option;
    }

    /**
     * 设置分析的描述
     *
     * @param option 分析的描述
     */
    public void setOption(String option) {
        this.option = option;
    }

    /**
     * 获取百度百科id
     *
     * @return bdbkKgId - 百度百科id
     */
    public String getBdbkkgid() {
        return bdbkkgid;
    }

    /**
     * 设置百度百科id
     *
     * @param bdbkkgid 百度百科id
     */
    public void setBdbkkgid(String bdbkkgid) {
        this.bdbkkgid = bdbkkgid;
    }

    /**
     * 获取书名，比如：史记，宋史
     *
     * @return bookName - 书名，比如：史记，宋史
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * 设置书名，比如：史记，宋史
     *
     * @param bookname 书名，比如：史记，宋史
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * 获取文章名，比如：夏本纪第二
     *
     * @return articleName - 文章名，比如：夏本纪第二
     */
    public String getArticlename() {
        return articlename;
    }

    /**
     * 设置文章名，比如：夏本纪第二
     *
     * @param articlename 文章名，比如：夏本纪第二
     */
    public void setArticlename(String articlename) {
        this.articlename = articlename;
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