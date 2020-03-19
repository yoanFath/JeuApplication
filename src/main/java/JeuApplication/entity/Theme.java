package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "theme_jeu")
public class Theme extends SimpleEntity{

    @Basic
    private String nom_theme;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "theme")
    @Fetch(value= FetchMode.SELECT)
    private Collection<Jeu> listeJeu;

    public Collection<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(Collection<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }

    public String getNom_theme() {
        return nom_theme;
    }

    public void setNom_theme(String nom_theme) {
        this.nom_theme = nom_theme;
    }
}
