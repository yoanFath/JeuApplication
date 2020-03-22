package JeuApplication.service;

import JeuApplication.entity.Jeu;
import JeuApplication.entity.Note;

public class NoteService {
    public static double getNote(Jeu jeu, Note... reviews) {
        int cumulNote = 0;
        for (Note review : reviews)
            cumulNote += review.getNote() + updateNoteDidier(jeu, review) + updateNoteArmande(jeu, review) + updateNoteGaston(jeu, review) + updateNoteLiz(jeu, review) + updateNoteStefan(jeu, review);
        return cumulNote / reviews.length;
    }

    private static int updateNoteDidier(Jeu jeu, Note review) {
        return jeu.getTheme().getNom_theme().equals("science-fiction") && review.getNom_testeur().equals("Didier Loyal") && review.getNote() <= 9 ? 1 : 0;
    }

    private static int updateNoteArmande(Jeu jeu, Note review) {
        return jeu.getGenre().getNom_genre().equals("gestion") && review.getNom_testeur().equals("Armande Moly") && review.getNote() < 10 ? 1 : 0;
    }

    private static int updateNoteGaston(Jeu jeu, Note review) {
        return jeu.getType().getNom_type().equals("jeu de cartes") && review.getNom_testeur().equals("Gaston Portaleau") && review.getNote() > 0 ? -1 : 0;
    }

    private static int updateNoteLiz(Jeu jeu, Note review) {
        return jeu.getEditeur().getNom_editeur().equals("édijeu") && review.getNom_testeur().equals("Liz Smallhead") && review.getNote() >= 2 ? -2 : 0;
    }

    private static int updateNoteStefan(Jeu jeu, Note review) {
        return jeu.getTheme().getNom_theme().equals("contemporain") && review.getNom_testeur().equals("Stefan Bergor") && review.getNote() >= 3 && review.getNote() <= 7 ? 1/2 : 0;
    }
}
