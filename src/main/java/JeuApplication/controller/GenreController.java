package JeuApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {

    @GetMapping("/genre")
    public String getGenres(Model model) {

        return "genre";
    }
}
