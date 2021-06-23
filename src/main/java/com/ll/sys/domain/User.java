package com.ll.sys.domain;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 23:04
 */

public class User {
    private Integer userid;

    private String loginname;

    private String identity;

    private String realname;

    private Integer sex;

    private String address;

    private String phone;

    private String pwd;

    private String position;

    private Integer type;

    private Integer available;

    public User() {
    }

    public User(Integer userid, String loginname, String identity, String realname, Integer sex, String address, String phone, String pwd, String position, Integer type, Integer available) {
        this.userid = userid;
        this.loginname = loginname;
        this.identity = identity;
        this.realname = realname;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.pwd = pwd;
        this.position = position;
        this.type = type;
        this.available = available;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname  == null ? null : realname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
