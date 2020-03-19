package JeuApplication.controller;

import JeuApplication.entity.Editeur;
import JeuApplication.service.EditeurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/editeur")
public class EditeurRestController extends SimpleController<Editeur>{

    public EditeurRestController(EditeurService editeurService) {
        super(editeurService);
    }

    @Override
    protected Editeur setName(String name, Editeur o) {
        o.setNom_editeur(name);
        return o;
    }

    @Override
    protected Editeur createEntity() {
        return new Editeur();
    }
}
