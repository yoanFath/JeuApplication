package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import JeuApplication.dao.JeuDAO;
import JeuApplication.entity.*;
import JeuApplication.service.*;

import java.util.List;

@Controller
public class JeuController {
    private final JeuService jeuService;
    private final EditeurService editeurService;
    private final ThemeService themeService;
    private final TypeService typeService;
    private final GenreService genreService;

    @Autowired
    public JeuController(JeuService jeuService, EditeurService editeurService, ThemeService themeService, TypeService typeService, GenreService genreService) {
        this.jeuService = jeuService;
        this.editeurService = editeurService;
        this.themeService = themeService;
        this.typeService = typeService;
        this.genreService = genreService;
    }

    @GetMapping("/jeu")
    public String getJeux(Model model) {
        return "jeu/all";
    }

    @GetMapping("/jeu/ajouter")
    public String ajouterJeu(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("themes", themeService.findAll());
        model.addAttribute("editeurs", editeurService.findAll());
        return "jeu/jeuForm";
    }
}
