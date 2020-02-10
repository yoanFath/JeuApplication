package JeuApplication.controller;

import JeuApplication.entity.Editeur;
import JeuApplication.service.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/editeur")
public class EditeurRestController {

    private final EditeurService editeurService;

    @Autowired
    public EditeurRestController(EditeurService editeurService) {
        this.editeurService = editeurService;
    }

    @GetMapping("/all")
    public List<Editeur> registration(Model model) {
        return editeurService.findAll();
    }
}
