package JeuApplication.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteDAO {

    @JsonProperty("nom_jeu")
    private String nom_jeu;
    @JsonProperty("nom_editeur")
    private String nom_editeur;
    @JsonProperty("nom_theme")
    private String nom_theme;
    @JsonProperty("nom_type")
    private String nom_type;
    @JsonProperty("nom_genre")
    private String nom_genre;
    @JsonProperty("note")
    private double note;

    public NoteDAO(String nom_jeu, String nom_editeur, String nom_theme, String nom_type, String nom_genre, double note) {
        this.nom_jeu = nom_jeu;
        this.nom_editeur = nom_editeur;
        this.nom_theme = nom_theme;
        this.nom_type = nom_type;
        this.nom_genre = nom_genre;
        this.note = note;
    }

    public String getNom_jeu() {
        return nom_jeu;
    }

    public void setNom_jeu(String nom_jeu) {
        this.nom_jeu = nom_jeu;
    }

    public String getNom_editeur() {
        return nom_editeur;
    }

    public void setNom_editeur(String nom_editeur) {
        this.nom_editeur = nom_editeur;
    }

    public String getNom_theme() {
        return nom_theme;
    }

    public void setNom_theme(String nom_theme) {
        this.nom_theme = nom_theme;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public String getNom_genre() {
        return nom_genre;
    }

    public void setNom_genre(String nom_genre) {
        this.nom_genre = nom_genre;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
