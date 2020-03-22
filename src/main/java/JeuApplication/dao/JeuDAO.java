package JeuApplication.dao;

public class JeuDAO {

    private String nom_jeu;
    private Long editeurId;
    private Long themeId;
    private Long typeId;
    private Long genreId;
    private int nombre_joueurs_maximum;
    private int nombre_joueurs_minimum;
    private int age_minimum;

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
