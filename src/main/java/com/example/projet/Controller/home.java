package com.example.projet.Controller;

import com.example.projet.Model.Article;
import com.example.projet.Model.Vente;
import com.example.projet.Service.ApprovisionnementService;
import com.example.projet.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class home {
    @Autowired
    VenteService venteService;
    @Autowired
    ApprovisionnementService approvisionnementService;

    @GetMapping("/")
    public String home (Model model){
        List<Vente> listVente = venteService.venteEtat(LocalDate.now(),LocalDate.now());
        int i = listVente.size();
        int total=0;
        for(int j =0;j<i;j++)
        {
            total+=listVente.get(j).getTotal();
        }

        List<Article> listeAppro = approvisionnementService.listeAapprovisionner();
        int nbrAappro = listeAppro.size();
        model.addAttribute("articles",listeAppro);
        model.addAttribute("i",i);
        model.addAttribute("total",total);
        model.addAttribute("Aappro",nbrAappro);
        return "home/home";
    }
}
