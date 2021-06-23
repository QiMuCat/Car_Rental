package com.ll.bus.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *
 * @author: 柒木Cat
 * @date: 2021/6/4 18:22
 * 汽车实体类
 */

public class Car {
    /**
    * carnumber     车牌号
    * cartype       车辆名称
    * color         车辆颜色
    * price         车辆价格
    * rentprice     出租价格
    * deposit       押金
    * isrenting     是否出租
    * description   车辆状态描述
    * carimg        车辆图片
    * createtime    时间
    * */
    private String carnumber;

    private String cartype;

    private String color;

    private Double price;

    private Double rentprice;

    private Double deposit;

    private Integer isrenting;

    private String description;

    private String carimg;
    /**
     * @JsonFormat
     * 注解是一个时间格式化注解，比如我们存储在mysql中的数据是date类型的，当我们读取出来封装在实体类中的时候，
     * 就会变成英文时间格式，而不是yyyy-MM-dd HH:mm:ss这样的中文时间，因此我们需要用到JsonFormat注解来
     * 格式化我们的时间
     * */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GTM+8")
    private Date createtime;

    public Car() {
    }

    public Car(String carnumber, String cartype, String color, Double price, Double rentprice, Double deposit, Integer isrenting, String description, String carimg, Date createtime) {
        this.carnumber = carnumber;
        this.cartype = cartype;
        this.color = color;
        this.price = price;
        this.rentprice = rentprice;
        this.deposit = deposit;
        this.isrenting = isrenting;
        this.description = description;
        this.carimg = carimg;
        this.createtime = createtime;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRentprice() {
        return rentprice;
    }

    public void setRentprice(Double rentprice) {
        this.rentprice = rentprice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(Integer isrenting) {
        this.isrenting = isrenting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg == null ? null : carimg.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
