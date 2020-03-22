package JeuApplication.adapter;

import JeuApplication.dao.JeuDAO;
import JeuApplication.entity.Jeu;

public class JeuAdapter {

    private JeuAdapter(){

    }

    public static Jeu adaptJeuDAOToJeu(JeuDAO jeudao){
        Jeu jeu = new Jeu();
        jeu.setEditeur(jeudao.getEditeur());
        jeu.setGenre(jeudao.getGenre());
        jeu.setNom_jeu(jeudao.getNom_jeu());
        jeu.setTheme(jeudao.getTheme());
        jeu.setType(jeudao.getType());
        jeu.setNombre_joueurs_maximum(jeudao.getNombre_joueurs_maximum());
        jeu.setNombre_joueurs_minimum(jeudao.getNombre_joueurs_minimum());
        jeu.setAge_minimum(jeudao.getAge_minimum());

        return jeu;
    }

    public static JeuDAO adaptJeuToJeuDAO(Jeu jeu){
        JeuDAO jeuDAO = new JeuDAO();
        jeuDAO.setEditeur(jeu.getEditeur());
        jeuDAO.setGenre(jeu.getGenre());
        jeuDAO.setNom_jeu(jeu.getNom_jeu());
        jeuDAO.setTheme(jeu.getTheme());
        jeuDAO.setType(jeu.getType());
        jeuDAO.setNombre_joueurs_maximum(jeu.getNombre_joueurs_maximum());
        jeuDAO.setNombre_joueurs_minimum(jeu.getNombre_joueurs_minimum());
        jeuDAO.setAge_minimum(jeu.getAge_minimum());

        return jeuDAO;
    }

}
