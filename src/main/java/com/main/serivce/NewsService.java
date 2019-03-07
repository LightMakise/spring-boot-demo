package com.main.serivce;

import com.main.model.News;

import java.util.List;

public interface NewsService {
    //添加新闻
    int add(News news);

    //根据id查找新闻
    News selectNews(Integer id);
}
