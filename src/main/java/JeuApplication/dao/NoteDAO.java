package JeuApplication.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteDAO {

    @JsonProperty("nom_jeu")
    private String nom_jeu;
    @JsonProperty("id_editeur")
    private Long editeurId;
    @JsonProperty("id_theme")
    private Long themeId;
    @JsonProperty("id_type")
    private Long typeId;
    @JsonProperty("id_genre")
    private Long genreId;
    @JsonProperty("note")
    private String note;

    public NoteDAO(String nom_jeu, Long editeurId, Long themeId, Long typeId, Long genreId, String note) {
        this.nom_jeu = nom_jeu;
        this.editeurId = editeurId;
        this.themeId = themeId;
        this.typeId = typeId;
        this.genreId = genreId;
        this.note = note;
    }

    public String getNom_jeu() {
        return nom_jeu;
    }

    public void setNom_jeu(String nom_jeu) {
        this.nom_jeu = nom_jeu;
    }

    public Long getEditeurId() {
        return editeurId;
    }

    public void setEditeurId(Long editeurId) {
        this.editeurId = editeurId;
    }

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
