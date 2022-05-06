package com.example.projet.Repository;

import com.example.projet.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {

    @Query("select v from Vente v where v.ref = :reff")
    List<Vente> venteListe(@Param("reff") String reff);
    @Query("select v from Vente v where v.date BETWEEN :date1 AND :date2  ")
    List<Vente> venteEtat(@Param("date1")LocalDate date1, @Param("date2") LocalDate date2);
}
