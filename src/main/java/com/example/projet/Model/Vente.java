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
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ref;
    private int qte;
    private int prix;
    private int total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name ="articleId",insertable = false,updatable = false)
    private Article article;
    private int articleId;
}
