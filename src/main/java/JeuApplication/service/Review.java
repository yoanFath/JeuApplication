package JeuApplication.service;

public class Review {
    private String nomTesteur;
    private int note;

    public Review(String nomTesteur, int note) {
        this.nomTesteur = nomTesteur;
        this.note = note;
    }

    public String getNomTesteur() {
        return nomTesteur;
    }

    public int getNote() {
        return note;
    }
}
