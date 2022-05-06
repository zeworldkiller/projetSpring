package com.example.projet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int prix;
    private  int qteStock;
    private int qteSeuil;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;
    @ManyToOne
    @JoinColumn(name ="categorieId",insertable = false,updatable = false)
    private Categorie categorie;
    private int categorieId;
}
