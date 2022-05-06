package com.example.projet.Controller;

import com.example.projet.Model.Article;
import com.example.projet.Service.ArticleService;
import com.example.projet.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategorieService categorieService;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("articles",articleService.listeArticle());
        return "article/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("categories",categorieService.listeCategorie());
        return "article/create";
    }
    @PostMapping("/store")
    public String store(Article article){
        article.setDateCreation(LocalDate.now());
        article.setQteStock(0);
        articleService.saveArticle(article);
        return "redirect:/article/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("oneArticle",articleService.oneArticle(id));
        model.addAttribute("categories",categorieService.listeCategorie());
        return "article/update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/article/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id,Model model){
        model.addAttribute("oneArticle",articleService.oneArticle(id));
        model.addAttribute("categories",categorieService.listeCategorie());
        return "article/delete";
    }
    @PostMapping("/destroy")
    public String destroy(@ModelAttribute("article") Article article){
        articleService.deleteArticle(article.getId());
        return "redirect:/article/";
    }

}
