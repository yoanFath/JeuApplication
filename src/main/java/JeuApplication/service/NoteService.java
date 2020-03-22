package JeuApplication.service;

import JeuApplication.entity.Jeu;
import JeuApplication.entity.Note;

public class NoteService {
    public static double getNote(Note... reviews) {
        int cumulNote = 0;
        for (Note review : reviews)
            cumulNote += review.getNote() + updateNoteDidier(review) + updateNoteArmande(review)
                    + updateNoteGaston(review) + updateNoteLiz(review) + updateNoteStefan(review);
        return cumulNote / reviews.length;
    }

    private static int updateNoteDidier(Note review) {
        return review.getJeu().getTheme().getNom_theme().equals("science-fiction")
                && review.getNom_testeur().equals("Didier Loyal") && review.getNote() <= 9 ? 1 : 0;
    }

    private static int updateNoteArmande(Note review) {
        return review.getJeu().getGenre().getNom_genre().equals("gestion")
                && review.getNom_testeur().equals("Armande Moly") && review.getNote() < 10 ? 1 : 0;
    }

    private static int updateNoteGaston(Note review) {
        return review.getJeu().getType().getNom_type().equals("jeu de cartes")
                && review.getNom_testeur().equals("Gaston Portaleau") && review.getNote() > 0 ? -1 : 0;
    }

    private static int updateNoteLiz(Note review) {
        return review.getJeu().getEditeur().getNom_editeur().equals("édijeu")
                && review.getNom_testeur().equals("Liz Smallhead") && review.getNote() >= 2 ? -2 : 0;
    }

    private static int updateNoteStefan(Note review) {
        return review.getJeu().getTheme().getNom_theme().equals("contemporain")
                && review.getNom_testeur().equals("Stefan Bergor") && review.getNote() >= 3 && review.getNote() <= 7 ? 1/2 : 0;
    }
}
