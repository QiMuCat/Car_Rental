package com.ll.bus.vo;


import com.ll.bus.domain.Rent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 22:36
 */

public class RentVo extends Rent {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

    /**
     * 扩展表单参数   将时间提交给前台
     * */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Data startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Data endTime;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Data getStartTime() {
        return startTime;
    }

    public void setStartTime(Data startTime) {
        this.startTime = startTime;
    }

    public Data getEndTime() {
        return endTime;
    }

    public void setEndTime(Data endTime) {
        this.endTime = endTime;
    }
}
