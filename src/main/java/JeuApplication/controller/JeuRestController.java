package JeuApplication.controller;

import JeuApplication.entity.Jeu;
import JeuApplication.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jeux")
public class JeuRestController {

    private final JeuService jeuService;

    @Autowired
    public JeuRestController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    @GetMapping("/all")
    public List<Jeu> registration(Model model) {
        return jeuService.findAll();
    }
}
