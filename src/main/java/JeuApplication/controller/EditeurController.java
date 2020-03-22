package JeuApplication.controller;

import JeuApplication.entity.Editeur;
import JeuApplication.service.EditeurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editeur")
public class EditeurController {

    private final EditeurService editeurService;

    public EditeurController(EditeurService editeurService) {
        this.editeurService = editeurService;
    }

    @GetMapping
    public String getEditeurs(Model model) {
        model.addAttribute("entite", "editeur");
        return "simpleEntity";
    }

    @GetMapping("/ajouter")
    public String addEditeur(Model model) {
        model.addAttribute("entite", "editeur");
        return "simpleEntityForm";
    }

    @GetMapping(value = {"/get/{sId}"})
    public String getEntity(@PathVariable String sId, Model model) {
        Long id = Long.parseLong(sId);
        Editeur editeur = editeurService.findById(id);
        model.addAttribute("editeur", editeur);
        return "simpleEntityForm";
    }
}
