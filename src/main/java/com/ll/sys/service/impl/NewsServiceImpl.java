package com.ll.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.sys.domain.News;
import com.ll.sys.mapper.NewsMapper;
import com.ll.sys.service.NewsService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 17:59
 */

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询所有公告
     * @param newsVo
     * @return
     * */
    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        Page<Object> page = PageHelper.startPage(newsVo.getPage(),newsVo.getLimit());
        List<News> data = this.newsMapper.queryAllNews(newsVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加公告
     * @param newsVo
     * */
    @Override
    public void addNews(NewsVo newsVo) {
        this.newsMapper.insertSelective(newsVo);
    }

    /**
     * 修改公告
     * @param newsVo
     * */
    @Override
    public void updateNews(NewsVo newsVo) {
        this.newsMapper.updateByPrimaryKeySelective(newsVo);
    }

    /**
     * 删除公告
     * @param newsid
     * */
    @Override
    public void deleteNews(Integer newsid) {
        this.newsMapper.deleteByPrimaryKey(newsid);
    }

    /**
     * 批量删除
     * @param ids
     * */
    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id:ids){
            deleteNews(id);
        }
    }

    /**
     * 查询一个公告
     * @param id
     * */
    @Override
    public News queryNewsById(Integer id) {
        return this.newsMapper.selectByPrimaryKey(id);
    }
}
