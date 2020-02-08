package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "editeur_jeu")
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String nom_editeur;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "editeur")
    private Collection<Jeu> listeJeu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
