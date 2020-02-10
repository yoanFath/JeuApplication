package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "theme_jeu")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Basic
    private String nom_theme;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "theme")
    private Collection<Jeu> listeJeu;

    public Collection<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(Collection<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_theme() {
        return nom_theme;
    }

    public void setNom_theme(String nom_theme) {
        this.nom_theme = nom_theme;
    }
}
