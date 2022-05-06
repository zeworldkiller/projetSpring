package com.example.projet.Controller;

import com.example.projet.Model.Approvisionnement;
import com.example.projet.Service.ApprovisionnementService;
import com.example.projet.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    ApprovisionnementService approvisionnementService;
    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("approvisionnements",approvisionnementService.listeApprovisionnement());
        return "approvisionnement/index";
    }
    @GetMapping("/approvisionner/{id}")
    public String create(@PathVariable("id") int id,Model model){
        model.addAttribute("oneArticle",articleService.oneArticle(id));
        return "approvisionnement/create";
    }
    @PostMapping("/store")
    public String store(Approvisionnement approvisionnement){
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        articleService.Approvisionner(approvisionnement.getArticleId(), approvisionnement.getQteAppro());
        return "redirect:/article/";
    }
    @GetMapping("/aapprovisionner")
    public String aapprovisionner(Model model){
        model.addAttribute("articles",approvisionnementService.listeAapprovisionner());

    return "approvisionnement/listeaapprivisionner";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("oneApprovisionnement",approvisionnementService.oneApprovisionnement(id));
        return "approvisionnement/update";
    }
    @PostMapping("/update/{qtt}")
    public String update(@PathVariable("qtt") int qtt,@ModelAttribute("appro") Approvisionnement appro){
        int qte = appro.getQteAppro() - qtt;
        articleService.Approvisionner(appro.getArticleId(),qte);
        approvisionnementService.saveApprovisionnement(appro);
        return "redirect:/approvisionnement/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id,Model model){
        model.addAttribute("oneApprovisionnement",approvisionnementService.oneApprovisionnement(id));
        return "approvisionnement/delete";
    }
    @PostMapping("/destroy")
    public String destroy(@ModelAttribute("appro") Approvisionnement appro)
    {

        int qtt = appro.getQteAppro()*-1;
        System.out.println(qtt);
        articleService.Approvisionner(appro.getArticleId(), qtt);
        approvisionnementService.delete(appro.getId());
        return "redirect:/article/";
    }

}
