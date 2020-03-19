package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "editeur_jeu")
public class Editeur extends SimpleEntity{

    @Basic
    private String nom_editeur;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "editeur")
    @Fetch(value= FetchMode.SELECT)
    private Collection<Jeu> listeJeu;

    public String getNom_editeur() {
        return nom_editeur;
    }

    public void setNom_editeur(String nom_editeur) {
        this.nom_editeur = nom_editeur;
    }

    public Collection<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(Collection<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }
}
