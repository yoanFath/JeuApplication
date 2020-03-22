package JeuApplication.controller;

import JeuApplication.entity.Editeur;
import JeuApplication.entity.Jeu;
import JeuApplication.service.EditeurService;
import JeuApplication.service.JeuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/editeur")
public class EditeurRestController extends SimpleController<Editeur>{
    private final JeuService jeuService;

    public EditeurRestController(EditeurService editeurService, JeuService jeuService) {
        super(editeurService);
        this.jeuService = jeuService;
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

    @Override
    protected void deleteJeu(Editeur o) {
        List<Jeu> jeux = jeuService.findByEditeur(o);
        for (Jeu jeu : jeux ){
            jeu.setEditeur(null);
            jeuService.save(jeu);
        }
    }


}
