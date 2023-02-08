package com.iloan.spring.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plateforme {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nom;

    @ManyToMany
    private List<JeuVideo> jeuxvideos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
