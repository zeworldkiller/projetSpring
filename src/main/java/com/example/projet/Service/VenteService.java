package com.example.projet.Service;

import com.example.projet.Model.Vente;
import com.example.projet.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public List<Vente> listeVente(String ref){
        return venteRepository.venteListe(ref);
    }
    public void saveVente(Vente vente){
        venteRepository.save(vente);
    }
    public void delete(int id){
        venteRepository.deleteById(id);
    }
    public Vente oneVente(int id){
        return venteRepository.findById(id).get();
    }
    public List<Vente> venteEtat(LocalDate date1,LocalDate date2){
        return venteRepository.venteEtat(date1,date2);
    }
    public List<Vente> ToutesVente(){
        return venteRepository.findAll();
    }
}
