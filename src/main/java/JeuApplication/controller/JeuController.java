package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JeuController {
    @GetMapping("/jeu")
    public String registration(Model model) {
        model.addAttribute("message", "coucou");

        return "jeu";
    }
}
