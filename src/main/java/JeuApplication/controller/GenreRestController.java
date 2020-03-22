package JeuApplication.controller;

import JeuApplication.entity.Genre;
import JeuApplication.entity.Jeu;
import JeuApplication.service.GenreService;
import JeuApplication.service.JeuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/genre")
public class GenreRestController extends SimpleController<Genre>{

    private final JeuService jeuService;

    public GenreRestController(GenreService service, JeuService jeuService) {
        super(service);
        this.jeuService = jeuService;
    }

    @Override
    protected Genre setName(String name, Genre o) {
        o.setNom_genre(name);
        return o;
    }

    @Override
    protected Genre createEntity() {
        return new Genre();
    }

    @Override
    protected void deleteJeu(Genre o) {
        List<Jeu> jeux = jeuService.findByGenre(o);
        for (Jeu jeu : jeux ){
            jeu.setGenre(null);
            jeuService.save(jeu);
        }
    }
}
