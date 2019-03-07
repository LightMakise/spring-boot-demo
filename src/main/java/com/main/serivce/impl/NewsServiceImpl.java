package com.main.serivce.impl;

import com.main.mapper.NewsMapper;
import com.main.model.News;
import com.main.serivce.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int add(News news) {
        return newsMapper.insertSelective(news);
    }

    @Override
    public News selectNews(Integer id){
        return newsMapper.selectByPrimaryKey(id);
    }
}
