package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThemeController {

    @GetMapping("/theme")
    public String getThemes(Model model) {
        model.addAttribute("entite", "theme");
        return "simpleEntity";
    }
}
