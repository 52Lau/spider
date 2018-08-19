package com.lau.spider.model;

import javax.persistence.*;

public class Music {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 点赞数
     */
    @Column(name = "likedCount")
    private Integer likedcount;

    /**
     * 评论者id
     */
    @Column(name = "userId")
    private Integer userid;

    /**
     * 歌曲id
     */
    @Column(name = "songId")
    private Integer songid;

    /**
     * 歌曲名字
     */
    @Column(name = "songName")
    private String songname;

    /**
     * 歌曲作者
     */
    @Column(name = "songAuthor")
    private String songauthor;

    private  Integer status;

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
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取点赞数
     *
     * @return likedCount - 点赞数
     */
    public Integer getLikedcount() {
        return likedcount;
    }

    /**
     * 设置点赞数
     *
     * @param likedcount 点赞数
     */
    public void setLikedcount(Integer likedcount) {
        this.likedcount = likedcount;
    }

    /**
     * 获取评论者id
     *
     * @return userId - 评论者id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置评论者id
     *
     * @param userid 评论者id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取歌曲id
     *
     * @return songId - 歌曲id
     */
    public Integer getSongid() {
        return songid;
    }

    /**
     * 设置歌曲id
     *
     * @param songid 歌曲id
     */
    public void setSongid(Integer songid) {
        this.songid = songid;
    }

    /**
     * 获取歌曲名字
     *
     * @return songName - 歌曲名字
     */
    public String getSongname() {
        return songname;
    }

    /**
     * 设置歌曲名字
     *
     * @param songname 歌曲名字
     */
    public void setSongname(String songname) {
        this.songname = songname;
    }

    /**
     * 获取歌曲作者
     *
     * @return songAuthor - 歌曲作者
     */
    public String getSongauthor() {
        return songauthor;
    }

    /**
     * 设置歌曲作者
     *
     * @param songauthor 歌曲作者
     */
    public void setSongauthor(String songauthor) {
        this.songauthor = songauthor;
    }
}