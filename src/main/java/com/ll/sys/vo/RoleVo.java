package com.ll.sys.vo;


import com.ll.sys.domain.Role;

/**
 * @author: 柒木Cat
 * @date: 2021/6/9 23:18
 */

public class RoleVo extends Role {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;
    /**
     * 接受多个id
     * */
    private Integer[] ids;

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
