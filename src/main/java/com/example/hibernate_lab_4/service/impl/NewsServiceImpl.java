package com.example.hibernate_lab_4.service.impl;

import com.example.hibernate_lab_4.dao.NewsDAO;
import com.example.hibernate_lab_4.entity.News;
import com.example.hibernate_lab_4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDAO newsDAO;

    @Override
    public List<News> getAllNews() {
        return newsDAO.getAllNews();
    }

    @Override
    public void saveNews(News news) {
        newsDAO.saveNews(news);
    }

    @Override
    public News getNews(int id) {
        return newsDAO.getNews(id);
    }

    @Override
    public void deleteNews(int id) {
        newsDAO.deleteNews(id);
    }
}