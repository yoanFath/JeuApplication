package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TypeController {

    @GetMapping("/type")
    public String getTypes(Model model) {
        model.addAttribute("entite", "type");
        return "simpleEntity";
    }
}
