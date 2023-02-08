package com.iloan.spring.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@DiscriminatorValue("J")
public class JeuVideo extends Article {
    private int limite_age;
    private String studio;
    private boolean exclusivite;

    @ManyToMany(mappedBy = "jeuxvideos")
    private List<Plateforme> plateformes;

    @ManyToMany(mappedBy = "jeuvideos")
    private List<Genre> genres;

    public int getLimite_age() {
        return limite_age;
    }

    public void setLimite_age(int limite_age) {
        this.limite_age = limite_age;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public boolean isExclusivite() {
        return exclusivite;
    }

    public void setExclusivite(boolean exclusivite) {
        this.exclusivite = exclusivite;
    }
}
