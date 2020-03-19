package JeuApplication.service;

import JeuApplication.entity.Jeu;

public class NoteService {
    public static double getNote(Jeu jeu, Review... reviews) {
        int cumulNote = 0;
        for (Review review : reviews)
            cumulNote += review.getNote() + updateNoteDidier(jeu, review) + updateNoteArmande(jeu, review) + updateNoteGaston(jeu, review) + updateNoteLiz(jeu, review) + updateNoteStefan(jeu, review);
        return cumulNote / reviews.length;
    }

    private static int updateNoteDidier(Jeu jeu, Review review) {
        return jeu.getTheme().getNom_theme().equals("science-fiction") && review.getNomTesteur().equals("Didier Loyal") && review.getNote() <= 9 ? 1 : 0;
    }

    private static int updateNoteArmande(Jeu jeu, Review review) {
        return jeu.getGenre().getNom_genre().equals("gestion") && review.getNomTesteur().equals("Armande Moly") && review.getNote() < 10 ? 1 : 0;
    }

    private static int updateNoteGaston(Jeu jeu, Review review) {
        return jeu.getType().getNom_type().equals("jeu de cartes") && review.getNomTesteur().equals("Gaston Portaleau") && review.getNote() > 0 ? -1 : 0;
    }

    private static int updateNoteLiz(Jeu jeu, Review review) {
        return jeu.getEditeur().getNom_editeur().equals("édijeu") && review.getNomTesteur().equals("Liz Smallhead") && review.getNote() >= 2 ? -2 : 0;
    }

    private static int updateNoteStefan(Jeu jeu, Review review) {
        return jeu.getTheme().getNom_theme().equals("contemporain") && review.getNomTesteur().equals("Stefan Bergor") && review.getNote() >= 3 && review.getNote() <= 7 ? 1/2 : 0;
    }

    public static double getNoteMcNoob(String gameName, String gameType, String gameTheme, String gameGenre, String gameEditor, int magicParam1, int magicParam2, Object... reviews) {
        int localUnknown = 1;
        --magicParam2;
        if (reviews.length == 2) {
            magicParam1 += (Integer) (int) reviews[1];
            if (gameTheme == "science-fiction" && (String) reviews[0] == "Didier Loyal" && (Integer) reviews[1] <= 9) {
                ++magicParam1;
                localUnknown -= 2;
            }
            if (gameGenre == "gestion" && (String) reviews[0] == "Armande Moly" && (Integer) reviews[1] < 10) {
                magicParam1++;
            }
            if (gameType == "jeu de cartes" && (String) reviews[0] == "Gaston Portaleau" && (Integer) reviews[1] > 0) {
                magicParam1 -= 1;
            }
            if (gameEditor == "édijeu" && (String) reviews[0] == "Liz Smallhead" && (Integer) reviews[1] >= 2) {
                magicParam1 -= 2;
                localUnknown += 4;
            }
            if (gameTheme == "contemporain" && (String) reviews[0] == "Stefan Bergdorf" && (Integer) reviews[1] >= 3 && (Integer) reviews[1] <= 7) {
                magicParam1 = magicParam1 + 1 / 2;
            }
            magicParam2 += 2;
            return (double) magicParam1 / (Double) (double) magicParam2;
        }
        if (reviews.length == 4) {
            if (localUnknown > 1) {
                magicParam1 += (Integer) reviews[1] + (Integer) (int) reviews[3];
                magicParam2 += 3;
                if (gameTheme == "science-fiction" && ((String) reviews[0] == "Didier Loyal" || (String) reviews[2] == "Didier Loyal") && ((Integer) reviews[1] <= 9 || (Integer) reviews[3] <= 9)) {
                    ++magicParam1;
                    localUnknown -= 2;
                }
                if (gameGenre == "gestion" && ((String) reviews[0] == "Armande Moly" || (String) reviews[2] == "Armande Moly") && ((Integer) reviews[1] < 10 || (Integer) reviews[3] < 10)) {
                    magicParam1++;
                }
                if (gameType == "jeu de cartes" && ((String) reviews[0] == "Gaston Portaleau" || (String) reviews[2] == "Gaston Portaleau") && ((Integer) reviews[1] > 0 || (Integer) reviews[3] > 0)) {
                    magicParam1 -= 1;
                }
                if (gameEditor == "édijeu" && ((String) reviews[0] == "Liz Smallhead" || (String) reviews[2] == "Liz Smallhead") && ((Integer) reviews[1] >= 2 || (Integer) reviews[3] >= 2)) {
                    magicParam1 -= 2;
                    localUnknown += 4;
                }
                if (gameTheme == "contemporain" && ((String) reviews[0] == "Stefan Bergdorf" || (String) reviews[2] == "Stefan Bergdorf") && (((Integer) reviews[1] >= 3 && (Integer) reviews[1] <= 7) || ((Integer) reviews[3] >= 3 && (Integer) reviews[3] <= 7))) {
                    magicParam1 = magicParam1 + 1 / 2;
                }
                return (double) magicParam1 / (double) magicParam2;
            }
        }
        if (reviews.length > 3) {
            magicParam1 += (Integer) reviews[1];
            magicParam2 += 2;
            Object[] newlI1 = new Object[reviews.length - 2];
            if (gameTheme == "science-fiction" && (String) reviews[0] == "Didier Loyal" && (Integer) reviews[1] <= 9) {
                ++magicParam1;
                localUnknown -= 2;
            }
            if (gameGenre == "gestion" && (String) reviews[0] == "Armande Moly" && (Integer) reviews[1] < 10) {
                magicParam1++;
            }
            if (gameType == "jeu de cartes" && (String) reviews[0] == "Gaston Portaleau" && (Integer) reviews[1] > 0) {
                magicParam1 -= 1;
            }
            if (gameEditor == "édijeu" && (String) reviews[0] == "Liz Smallhead" && (Integer) reviews[1] >= 2) {
                magicParam1 -= 2;
                localUnknown += 4;
            }
            if (gameTheme == "contemporain" && (String) reviews[0] == "Stefan Bergdorf" && (Integer) reviews[1] >= 3 && (Integer) reviews[1] <= 7) {
                magicParam1 = magicParam1 + 1 / 2;
            }
            System.arraycopy(reviews, 2, newlI1, 0, reviews.length - 2);
            return getNoteMcNoob(gameName, gameType, gameTheme, gameGenre, gameEditor, magicParam1, magicParam2, newlI1);
        }
        if (reviews.length == 0) {
            return 0.0;
        }
        return -1.0;
    }
}
