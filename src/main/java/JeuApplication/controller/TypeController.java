package JeuApplication.controller;

import JeuApplication.entity.Type;
import JeuApplication.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("type")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public String getTypes(Model model) {
        model.addAttribute("entite", "type");
        return "simpleEntity";
    }

    @GetMapping("/ajouter")
    public String addType(Model model) {
        model.addAttribute("entite", "type");
        return "simpleEntityForm";
    }

    @GetMapping(value = {"/get/{sId}"})
    public String getEntity(@PathVariable String sId, Model model) {
        Long id = Long.parseLong(sId);
        Type type = typeService.findById(id);
        model.addAttribute("currentName", type.getNom_type());
        model.addAttribute("entiteId", type.getId());
        model.addAttribute("entite", "type");
        return "simpleEntityForm";
    }
}
