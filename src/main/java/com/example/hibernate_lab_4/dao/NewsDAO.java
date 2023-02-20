package com.example.hibernate_lab_4.dao;

import com.example.hibernate_lab_4.entity.News;

import java.util.List;

public interface NewsDAO {

    public List<News> getAllNews();

    public void saveNews(News news);

    public News getNews(int id);

    public void deleteNews(int id);
}
