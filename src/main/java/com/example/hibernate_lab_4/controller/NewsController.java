package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.News;
import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.entity.Worker;
import com.example.hibernate_lab_4.service.HouseService;
import com.example.hibernate_lab_4.service.NewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/allNews")
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    HouseService houseService;

    @GetMapping("")
    public String showMainPage(Model model) {

        model.addAttribute("news", newsService.getAllNews());

        return "news/all-news";
    }

    @GetMapping("/addNews")
    public String addNews(Model model) {

        model.addAttribute("news", new News());
        return "news/add-news";
    }

    @PostMapping("/addNews")
    public String addNews(@ModelAttribute("news") News news) {
        news.setHouse(houseService.getHouse(1));
        newsService.saveNews(news);

        return "redirect:/allNews";
    }

    @GetMapping("/{id}/edit")
    public String editNews(@PathVariable(value = "id") Integer id, Model model) {
        if (newsService.getNews(id) == null) {
            return "redirect:/allNews";
        }
        model.addAttribute("news", newsService.getNews(id));

        return "news/news-edit";
    }

    @PostMapping("/{id}/edit")
    public String editNews(@PathVariable(value = "id") Integer id, @RequestParam String type,
                           @RequestParam String info) {

        News news = newsService.getNews(id);
        news.setType(type);
        news.setInfo(info);
        newsService.saveNews(news);

        return "redirect:/allNews";
    }

    @PostMapping("/{id}/remove")
    public String deleteWorker(@PathVariable(value = "id") Integer id) {
        newsService.deleteNews(id);

        return "redirect:/allNews";
    }
}
