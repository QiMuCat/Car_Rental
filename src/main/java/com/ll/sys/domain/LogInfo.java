package com.ll.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 22:46
 */

public class LogInfo {
    private Integer id;

    private String loginname;

    private String loginip;

    //转换到页面上的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}
