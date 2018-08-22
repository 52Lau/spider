package com.lau.spider.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_enable")
    private String loginEnable;

    @Column(name = "login_error")
    private Integer loginError;

    @Column(name = "login_last")
    private Date loginLast;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "user_desc")
    private String userDesc;

    @Column(name = "user_display_name")
    private String userDisplayName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "user_balance")
    private Integer userBalance;

    @Column(name = "user_mac")
    private Integer userMac;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return login_enable
     */
    public String getLoginEnable() {
        return loginEnable;
    }

    /**
     * @param loginEnable
     */
    public void setLoginEnable(String loginEnable) {
        this.loginEnable = loginEnable;
    }

    /**
     * @return login_error
     */
    public Integer getLoginError() {
        return loginError;
    }

    /**
     * @param loginError
     */
    public void setLoginError(Integer loginError) {
        this.loginError = loginError;
    }

    /**
     * @return login_last
     */
    public Date getLoginLast() {
        return loginLast;
    }

    /**
     * @param loginLast
     */
    public void setLoginLast(Date loginLast) {
        this.loginLast = loginLast;
    }

    /**
     * @return user_avatar
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * @param userAvatar
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * @return user_desc
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * @param userDesc
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * @return user_display_name
     */
    public String getUserDisplayName() {
        return userDisplayName;
    }

    /**
     * @param userDisplayName
     */
    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_pass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return user_balance
     */
    public Integer getUserBalance() {
        return userBalance;
    }

    /**
     * @param userBalance
     */
    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    public Integer getUserMac() {
        return userMac;
    }

    public void setUserMac(Integer userMac) {
        this.userMac = userMac;
    }
}