package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditeurController {

    @GetMapping("/editeur")
    public String getEditeurs(Model model) {

        return "editeur";
    }
}
