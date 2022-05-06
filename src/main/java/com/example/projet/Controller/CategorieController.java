package com.example.projet.Controller;

import com.example.projet.Model.Categorie;
import com.example.projet.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @GetMapping("/")
    public String index(Model model){
    model.addAttribute("listeCategorie",categorieService.listeCategorie());
    return "categorie/liste";
    }
    @GetMapping("/create")
    public String create(){
        return "categorie/create";
    }

    @PostMapping("/store")
    public String store(Categorie categorie){
    categorieService.saveCategorie(categorie);
    return "redirect:/categorie/";
    }
    @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id,Model model){

        model.addAttribute("categorie",categorieService.oneCategorie(id));
        return "categorie/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("categorie") Categorie categorie){
    categorieService.saveCategorie(categorie);
    return "redirect:/categorie/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id, Model model)
    { model.addAttribute("categorie",categorieService.oneCategorie(id));
        return "categorie/delete";
    }
    @PostMapping("/destroy")
    public String destroy(@ModelAttribute("categorie") Categorie categorie){
        categorieService.deleteCategorie(categorie.getId());
        return "redirect:/categorie/";
    }
}
