package com.ll.sys.vo;


import com.ll.sys.domain.Menu;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 23:12
 */

public class MenuVo extends Menu {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

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

}
