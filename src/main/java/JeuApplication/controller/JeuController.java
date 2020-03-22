package JeuApplication.controller;

import JeuApplication.entity.Jeu;
import JeuApplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/jeu/modifier/{sId}")
    public String modifierJeu(Model model,@PathVariable String sId) {
            Long id = Long.parseLong(sId);
            Jeu jeu = jeuService.findById(id);
            model.addAttribute("jeu",jeu);

        return "jeu/jeuForm";
    }
}
