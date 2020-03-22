package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {
    @GetMapping("/genre")
    public String getGenres(Model model) {
        model.addAttribute("entite", "genre");
        return "simpleEntity";
    }

    @GetMapping("/genre/ajouter")
    public String addGenre(Model model) {
        model.addAttribute("entite", "genre");
        return "simpleEntityForm";
    }
}
