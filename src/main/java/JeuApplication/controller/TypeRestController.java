package JeuApplication.controller;

import JeuApplication.entity.Jeu;
import JeuApplication.entity.Type;
import JeuApplication.service.JeuService;
import JeuApplication.service.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeRestController extends SimpleController<Type> {
    private final JeuService jeuService;
    public TypeRestController(TypeService service, JeuService jeuService) {
        super(service);
        this.jeuService = jeuService;
    }

    @Override
    protected Type setName(String name, Type o) {
        o.setNom_type(name);
        return o;
    }

    @Override
    protected Type createEntity() {
        return new Type();
    }

    @Override
    protected void deleteJeu(Type o) {
        List<Jeu> jeux = jeuService.findByType(o);
        for (Jeu jeu : jeux ){
            jeu.setType(null);
            jeuService.save(jeu);
        }
    }
}
