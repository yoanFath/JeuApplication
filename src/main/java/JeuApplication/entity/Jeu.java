package JeuApplication.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "jeu")
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Basic
    private String nom_jeu;

    @Basic
    private int age_minimum;

    @Basic
    private int nombre_joueurs_minimum;

    @Basic
    private int nombre_joueurs_maximum;


    @ManyToOne(targetEntity=Editeur.class)
    @JoinColumn(name = "id_editeur", referencedColumnName = "id", nullable = false)
    private Editeur editeur;


    @ManyToOne(targetEntity=Type.class)
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false)
    private Type type;

    @ManyToOne(targetEntity=Theme.class)
    @JoinColumn(name = "id_theme", referencedColumnName = "id", nullable = false)
    private Theme theme;

    @ManyToOne(targetEntity=Genre.class)
    @JoinColumn(name = "id_genre", referencedColumnName = "id", nullable = false)
    private Genre genre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jeu")
    private Collection<Note> listeNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_jeu() {
        return nom_jeu;
    }

    public void setNom_jeu(String nom_jeu) {
        this.nom_jeu = nom_jeu;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Collection<Note> getListeNote() {
        return listeNote;
    }

    public void setListeNote(Collection<Note> listeNote) {
        this.listeNote = listeNote;
    }

    public int getAge_minimum() {
        return age_minimum;
    }

    public void setAge_minimum(int age_minimum) {
        this.age_minimum = age_minimum;
    }

    public int getNombre_joueurs_minimum() {
        return nombre_joueurs_minimum;
    }

    public void setNombre_joueurs_minimum(int nombre_joueurs_minimum) {
        this.nombre_joueurs_minimum = nombre_joueurs_minimum;
    }

    public int getNombre_joueurs_maximum() {
        return nombre_joueurs_maximum;
    }

    public void setNombre_joueurs_maximum(int nombre_joueurs_maximum) {
        this.nombre_joueurs_maximum = nombre_joueurs_maximum;
    }
}
