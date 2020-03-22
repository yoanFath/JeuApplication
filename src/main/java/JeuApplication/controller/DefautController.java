package JeuApplication.controller;


import JeuApplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefautController {

    private final TypeService typeService;
    private final GenreService genreService;
    private final ThemeService themeService;
    private final EditeurService editeurService;
    private final JeuService jeuxService;

    @Autowired
    public DefautController(TypeService typeService, GenreService genreService, ThemeService themeService, EditeurService editeurService, JeuService jeuxService) {
        this.typeService = typeService;
        this.genreService = genreService;
        this.themeService = themeService;
        this.editeurService = editeurService;
        this.jeuxService = jeuxService;
    }

    @GetMapping("/")
    public String getFiltre(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("themes", themeService.findAll());
        model.addAttribute("editeurs", editeurService.findAll());
        return "accueil";
    }
}
