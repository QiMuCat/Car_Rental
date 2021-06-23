package com.ll.bus.vo;


import com.ll.bus.domain.Car;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 22:28
 */

public class CarVo extends Car {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

    //接受多个id
    private String[] ids;


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

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
