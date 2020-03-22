package JeuApplication.controller;

import JeuApplication.entity.Theme;
import JeuApplication.service.ThemeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("theme")
public class ThemeController {
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public String getThemes(Model model) {
        model.addAttribute("entite", "theme");
        return "simpleEntity";
    }

    @GetMapping("/ajouter")
    public String addTheme(Model model) {
        model.addAttribute("entite", "theme");
        return "simpleEntityForm";
    }

    @GetMapping(value = {"/get/{sId}"})
    public String getEntity(@PathVariable String sId, Model model) {
        Long id = Long.parseLong(sId);
        Theme theme = themeService.findById(id);
        model.addAttribute("currentName", theme.getNom_theme());
        model.addAttribute("entiteId", theme.getId());
        model.addAttribute("entite", "theme");
        return "simpleEntityForm";
    }
}
