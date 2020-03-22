package JeuApplication.dao;

import JeuApplication.entity.Editeur;
import JeuApplication.entity.Genre;
import JeuApplication.entity.Theme;
import JeuApplication.entity.Type;

public class JeuDAO {

    private String nom_jeu;
    private Editeur editeur;
    private Theme theme;
    private Type type;
    private Genre genre;
    private int nombre_joueurs_maximum;
    private int nombre_joueurs_minimum;
    private int age_minimum;

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getNom_jeu() {
        return nom_jeu;
    }

    public void setNom_jeu(String nom_jeu) {
        this.nom_jeu = nom_jeu;
    }

    public int getNombre_joueurs_maximum() {
        return nombre_joueurs_maximum;
    }

    public void setNombre_joueurs_maximum(int nombre_joueurs_maximum) {
        this.nombre_joueurs_maximum = nombre_joueurs_maximum;
    }

    public int getNombre_joueurs_minimum() {
        return nombre_joueurs_minimum;
    }

    public void setNombre_joueurs_minimum(int nombre_joueurs_minimum) {
        this.nombre_joueurs_minimum = nombre_joueurs_minimum;
    }

    public int getAge_minimum() {
        return age_minimum;
    }

    public void setAge_minimum(int age_minimum) {
        this.age_minimum = age_minimum;
    }
}
