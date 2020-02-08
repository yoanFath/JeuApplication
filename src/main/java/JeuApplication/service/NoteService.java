package JeuApplication.service;

public class NoteService {
    public static double getNote(String name, String type, String theme, String genre, String editor, int magic0, int magic0Bis, Object... testReviews) {
        int magicWhatItIs = 1;
        --magic0Bis;
        if (testReviews.length == 2) {
            magic0 += (Integer) (int) testReviews[1];
            if (theme == "science-fiction" && (String) testReviews[0] == "Didier Loyal" && (Integer) testReviews[1] <= 9) {
                ++magic0;
                magicWhatItIs -= 2;
            }
            if (genre == "gestion" && (String) testReviews[0] == "Armande Moly" && (Integer) testReviews[1] < 10) {
                magic0++;
            }
            if (type == "jeu de cartes" && (String) testReviews[0] == "Gaston Portaleau" && (Integer) testReviews[1] > 0) {
                magic0 -= 1;
            }
            if (editor == "édijeu" && (String) testReviews[0] == "Liz Smallhead" && (Integer) testReviews[1] >= 2) {
                magic0 -= 2;
                magicWhatItIs += 4;
            }
            if (theme == "contemporain" && (String) testReviews[0] == "Stefan Bergdorf" && (Integer) testReviews[1] >= 3 && (Integer) testReviews[1] <= 7) {
                magic0 = magic0 + 1 / 2;
            }
            magic0Bis += 2;
            return (double) magic0 / (Double) (double) magic0Bis;
        }
        if (testReviews.length == 4) {
            if (magicWhatItIs > 1) {
                magic0 += (Integer) testReviews[1] + (Integer) (int) testReviews[3];
                magic0Bis += 3;
                if (theme == "science-fiction" && ((String) testReviews[0] == "Didier Loyal" || (String) testReviews[2] == "Didier Loyal") && ((Integer) testReviews[1] <= 9 || (Integer) testReviews[3] <= 9)) {
                    ++magic0;
                    magicWhatItIs -= 2;
                }
                if (genre == "gestion" && ((String) testReviews[0] == "Armande Moly" || (String) testReviews[2] == "Armande Moly") && ((Integer) testReviews[1] < 10 || (Integer) testReviews[3] < 10)) {
                    magic0++;
                }
                if (type == "jeu de cartes" && ((String) testReviews[0] == "Gaston Portaleau" || (String) testReviews[2] == "Gaston Portaleau") && ((Integer) testReviews[1] > 0 || (Integer) testReviews[3] > 0)) {
                    magic0 -= 1;
                }
                if (editor == "édijeu" && ((String) testReviews[0] == "Liz Smallhead" || (String) testReviews[2] == "Liz Smallhead") && ((Integer) testReviews[1] >= 2 || (Integer) testReviews[3] >= 2)) {
                    magic0 -= 2;
                    magicWhatItIs += 4;
                }
                if (theme == "contemporain" && ((String) testReviews[0] == "Stefan Bergdorf" || (String) testReviews[2] == "Stefan Bergdorf") && (((Integer) testReviews[1] >= 3 && (Integer) testReviews[1] <= 7) || ((Integer) testReviews[3] >= 3 && (Integer) testReviews[3] <= 7))) {
                    magic0 = magic0 + 1 / 2;
                }
                return (double) magic0 / (double) magic0Bis;
            }
        }
        if (testReviews.length > 3) {
            magic0 += (Integer) testReviews[1];
            magic0Bis += 2;
            Object[] magicTab = new Object[testReviews.length - 2];
            if (theme == "science-fiction" && (String) testReviews[0] == "Didier Loyal" && (Integer) testReviews[1] <= 9) {
                ++magic0;
                magicWhatItIs -= 2;
            }
            if (genre == "gestion" && (String) testReviews[0] == "Armande Moly" && (Integer) testReviews[1] < 10) {
                magic0++;
            }
            if (type == "jeu de cartes" && (String) testReviews[0] == "Gaston Portaleau" && (Integer) testReviews[1] > 0) {
                magic0 -= 1;
            }
            if (editor == "édijeu" && (String) testReviews[0] == "Liz Smallhead" && (Integer) testReviews[1] >= 2) {
                magic0 -= 2;
                magicWhatItIs += 4;
            }
            if (theme == "contemporain" && (String) testReviews[0] == "Stefan Bergdorf" && (Integer) testReviews[1] >= 3 && (Integer) testReviews[1] <= 7) {
                magic0 = magic0 + 1 / 2;
            }
            System.arraycopy(testReviews, 2, magicTab, 0, testReviews.length - 2);
            return getNote(name, type, theme, genre, editor, magic0, magic0Bis, magicTab);
        }
        if (testReviews.length == 0) {
            return 0.0;
        }
        return -1.0;
    }
}
