package JeuApplication.service;

import JeuApplication.entity.Genre;
import JeuApplication.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends SimpleService<Genre> {

    protected GenreService(GenreRepository repo) {
        super(repo);
    }
}
