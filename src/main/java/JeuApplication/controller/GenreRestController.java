package JeuApplication.controller;

import JeuApplication.entity.Genre;
import JeuApplication.service.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/genre")
public class GenreRestController extends SimpleController<Genre>{

    public GenreRestController(GenreService service) {
        super(service);
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
}
