package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type_jeu")
public class Type extends SimpleEntity{

    @Basic
    private String nom_type;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "type")
    @Fetch(value= FetchMode.SELECT)
    private Collection<Jeu> listeJeu;

    public Collection<Jeu> getListeJeu() {
        return listeJeu;
    }

    public void setListeJeu(Collection<Jeu> listeJeu) {
        this.listeJeu = listeJeu;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }
}
