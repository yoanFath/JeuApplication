package JeuApplication.controller;

import JeuApplication.entity.Genre;
import JeuApplication.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String getGenres(Model model) {
        model.addAttribute("entite", "genre");
        return "simpleEntity";
    }

    @GetMapping("/ajouter")
    public String addGenre(Model model) {
        model.addAttribute("entite", "genre");
        return "simpleEntityForm";
    }

    @GetMapping(value = {"/get/{sId}"})
    public String getEntity(@PathVariable String sId, Model model) {
        Long id = Long.parseLong(sId);
        Genre genre = genreService.findById(id);
        model.addAttribute("currentName", genre.getNom_genre());
        model.addAttribute("entiteId", genre.getId());
        model.addAttribute("entite", "genre");
        return "simpleEntityForm";
    }
}
