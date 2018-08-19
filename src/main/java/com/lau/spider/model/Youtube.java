package com.lau.spider.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

public class Youtube {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 视频名称
     */
    private String name;

    /**
     * 视频Id
     */
    @Column(name = "videoId")
    private String videoid;

    /**
     * 视频URL
     */
    private String url;

    /**
     * 分类id
     */
    @Column(name = "catId")
    private Integer catid;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdate;

    /**
     * 是否已经合成Video和音频
     */
    @Column(name = "isVideoAudio")
    private Integer isvideoaudio;

    /**
     * 是否已经下载字幕
     */
    @Column(name = "isSubtitle")
    private Integer issubtitle;

    /**
     * 是否剪辑
     */
    @Column(name = "isClip")
    private Integer isclip;

    /**
     * 是否已经发布
     */
    @Column(name = "isSend")
    private Integer issend;

    /**
     * 状态0正常 1禁用
     */
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "Remarks")
    private String remarks;

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
     * 获取视频名称
     *
     * @return name - 视频名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置视频名称
     *
     * @param name 视频名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取视频Id
     *
     * @return videoId - 视频Id
     */
    public String getVideoid() {
        return videoid;
    }

    /**
     * 设置视频Id
     *
     * @param videoid 视频Id
     */
    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    /**
     * 获取视频URL
     *
     * @return url - 视频URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频URL
     *
     * @param url 视频URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取分类id
     *
     * @return catId - 分类id
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
     * 获取是否已经合成Video和音频
     *
     * @return isVideoAudio - 是否已经合成Video和音频
     */
    public Integer getIsvideoaudio() {
        return isvideoaudio;
    }

    /**
     * 设置是否已经合成Video和音频
     *
     * @param isvideoaudio 是否已经合成Video和音频
     */
    public void setIsvideoaudio(Integer isvideoaudio) {
        this.isvideoaudio = isvideoaudio;
    }

    /**
     * 获取是否已经下载字幕
     *
     * @return isSubtitle - 是否已经下载字幕
     */
    public Integer getIssubtitle() {
        return issubtitle;
    }

    /**
     * 设置是否已经下载字幕
     *
     * @param issubtitle 是否已经下载字幕
     */
    public void setIssubtitle(Integer issubtitle) {
        this.issubtitle = issubtitle;
    }

    /**
     * 获取是否剪辑
     *
     * @return isClip - 是否剪辑
     */
    public Integer getIsclip() {
        return isclip;
    }

    /**
     * 设置是否剪辑
     *
     * @param isclip 是否剪辑
     */
    public void setIsclip(Integer isclip) {
        this.isclip = isclip;
    }

    /**
     * 获取是否已经发布
     *
     * @return isSend - 是否已经发布
     */
    public Integer getIssend() {
        return issend;
    }

    /**
     * 设置是否已经发布
     *
     * @param issend 是否已经发布
     */
    public void setIssend(Integer issend) {
        this.issend = issend;
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

    /**
     * 获取备注
     *
     * @return Remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}