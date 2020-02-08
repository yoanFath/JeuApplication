package JeuApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "note_jeu")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private int note;

    @Basic
    private String nom_testeur;

    @JsonBackReference
    @ManyToOne(targetEntity=Jeu.class)
    @JoinColumn(name = "id_jeu", referencedColumnName = "id", nullable = false)
    private Jeu jeu;

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getNom_testeur() {
        return nom_testeur;
    }

    public void setNom_testeur(String nom_testeur) {
        this.nom_testeur = nom_testeur;
    }
}