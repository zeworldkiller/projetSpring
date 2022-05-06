package com.example.projet.Service;

import com.example.projet.Model.Approvisionnement;
import com.example.projet.Model.Article;
import com.example.projet.Repository.ApprovisionnemantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    ApprovisionnemantRepository approvisionnemantRepository;

    public void saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnemantRepository.save(approvisionnement);
    }

    public List<Approvisionnement> listeApprovisionnement(){
        return approvisionnemantRepository.findAll();
    }

    public  Approvisionnement oneApprovisionnement(int id){
        return  approvisionnemantRepository.findById(id).get();
    }
    public void delete(int id){
        approvisionnemantRepository.deleteById(id);
    }
    public List<Article> listeAapprovisionner(){
      return approvisionnemantRepository.listeAApprovisionner();
    }

    public List<Approvisionnement> approvisionnementEtat(LocalDate date1, LocalDate date2){
        return approvisionnemantRepository.approvisionnementEtat(date1,date2);
    }
}
