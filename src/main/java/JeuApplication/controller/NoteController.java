package JeuApplication.controller;

import JeuApplication.dao.JeuDAO;
import JeuApplication.dao.NoteDAO;
import JeuApplication.entity.*;
import JeuApplication.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    private final JeuService jeuService;
    private final EditeurService editeurService;
    private final ThemeService themeService;
    private final TypeService typeService;
    private final GenreService genreService;

    public NoteController(JeuService jeuService, EditeurService editeurService, ThemeService themeService, TypeService typeService, GenreService genreService) {
        this.jeuService = jeuService;
        this.editeurService = editeurService;
        this.themeService = themeService;
        this.typeService = typeService;
        this.genreService = genreService;
    }

    @PostMapping("/findWithFilter")
    public String findWithFilter(JeuDAO jeudao, Model model) {
        List<NoteDAO> res = new ArrayList<>();

        Type type = typeService.findById(jeudao.getTypeId());
        Editeur editeur = editeurService.findById(jeudao.getEditeurId());
        Theme theme = themeService.findById(jeudao.getThemeId());
        Genre genre = genreService.findById(jeudao.getGenreId());

        Integer ageMin = jeudao.getAge_minimum() == 0 ? null : jeudao.getAge_minimum();
        Integer nbJMin = jeudao.getNombre_joueurs_minimum() == 0 ? null : jeudao.getNombre_joueurs_minimum();
        Integer nbJMax = jeudao.getNombre_joueurs_maximum() == 0 ? null : jeudao.getNombre_joueurs_maximum();
        List<Jeu> jeux;
        NoteDAO temp;
        if (type == null && editeur == null && theme == null && genre == null && ageMin == null && nbJMax == null && nbJMin == null) {
            jeux = jeuService.findAll();
        } else {
            jeux = jeuService.findjeuxWithFilter(type, genre, theme, nbJMin,
                    nbJMax, ageMin, editeur);
        }
        for (Jeu jeu : jeux) {
            temp = new NoteDAO(jeu.getNom_jeu(), jeu.getEditeur().getNom_editeur(), jeu.getTheme().getNom_theme(), jeu.getType().getNom_type(),
                    jeu.getGenre().getNom_genre(), NoteService.getNote(jeu.getListeNote()));
            res.add(temp);
        }

        model.addAttribute("noteDao",res);
        return "note/all";
    }
}
