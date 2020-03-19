package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genre_jeu")
public class Genre extends SimpleEntity{

    @Basic
    private String nom_genre;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    @Fetch(value= FetchMode.SELECT)
    private Collection<Jeu> listeJeu;

    public Collection<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(Collection<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }

    public String getNom_genre() {
        return nom_genre;
    }

    public void setNom_genre(String nom_genre) {
        this.nom_genre = nom_genre;
    }
}
