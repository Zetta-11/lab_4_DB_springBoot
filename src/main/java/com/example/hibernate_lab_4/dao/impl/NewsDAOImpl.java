package com.example.hibernate_lab_4.dao.impl;

import com.example.hibernate_lab_4.dao.NewsDAO;
import com.example.hibernate_lab_4.entity.News;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private EntityManager manager;

    @Override
    public List<News> getAllNews() {
        Session session = manager.unwrap(Session.class);

        return session.createQuery("from News ", News.class).getResultList();
    }

    @Override
    public void saveNews(News news) {
        Session session = manager.unwrap(Session.class);
        session.persist(news);
    }

    @Override
    public News getNews(int id) {
        Session session = manager.unwrap(Session.class);

        return session.get(News.class, id);
    }

    @Override
    public void deleteNews(int id) {
        Session session = manager.unwrap(Session.class);

        Query query = session.createQuery("delete from News where id =:e");
        query.setParameter("e", id);
        query.executeUpdate();
    }
}