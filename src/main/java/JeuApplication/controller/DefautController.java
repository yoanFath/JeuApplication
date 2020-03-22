package JeuApplication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefautController {

    @GetMapping("/")
    public String registration(Model model) {

        return "filtre";
    }
}
