package com.example.projet.Repository;

import com.example.projet.Model.Approvisionnement;
import com.example.projet.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApprovisionnemantRepository extends JpaRepository<Approvisionnement,Integer> {

    @Query("select a from Article a where a.qteStock <= a.qteSeuil")
    public List<Article> listeAApprovisionner();

    @Query("select a from Approvisionnement a where a.dateAppro BETWEEN :date1 AND :date2 ")
    List<Approvisionnement> approvisionnementEtat(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);
}
