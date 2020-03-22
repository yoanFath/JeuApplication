package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditeurController {

    @GetMapping("/editeur")
    public String getEditeurs(Model model) {
        model.addAttribute("entite", "editeur");
        return "simpleEntity";
    }

    @GetMapping("/editeur/ajouter")
    public String addEditeur(Model model) {
        model.addAttribute("entite", "editeur");
        return "simpleEntityForm";
    }
}
