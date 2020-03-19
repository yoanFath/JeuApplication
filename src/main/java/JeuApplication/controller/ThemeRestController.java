package JeuApplication.controller;

import JeuApplication.entity.Theme;
import JeuApplication.service.ThemeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/theme")
public class ThemeRestController extends SimpleController<Theme>{

    public ThemeRestController(ThemeService service) {
        super(service);
    }

    @Override
    protected Theme setName(String name, Theme o) {
        o.setNom_theme(name);
        return o;
    }

    @Override
    protected Theme createEntity() {
        return new Theme();
    }
}
