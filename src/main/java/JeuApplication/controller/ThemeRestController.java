package JeuApplication.controller;

import JeuApplication.entity.Jeu;
import JeuApplication.entity.Theme;
import JeuApplication.service.JeuService;
import JeuApplication.service.ThemeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/theme")
public class ThemeRestController extends SimpleController<Theme>{
    private final JeuService jeuService;
    public ThemeRestController(ThemeService service, JeuService jeuService) {
        super(service);
        this.jeuService = jeuService;
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

    @Override
    protected void deleteJeu(Theme o) {
        List<Jeu> jeux = jeuService.findByTheme(o);
        for (Jeu jeu : jeux ){
            jeu.setTheme(null);
            jeuService.save(jeu);
        }
    }
}
