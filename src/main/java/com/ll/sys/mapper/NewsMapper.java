package com.ll.sys.mapper;


import com.ll.sys.domain.News;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 17:10
 */


public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 查询
     *
     * */
    List<News> queryAllNews(News news);
}
