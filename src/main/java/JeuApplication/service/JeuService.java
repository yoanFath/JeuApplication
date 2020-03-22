package JeuApplication.service;

import JeuApplication.entity.*;
import JeuApplication.repository.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuService {

    private final JeuRepository jeuRepository;

    @Autowired
    public JeuService(JeuRepository jeuRepository){
        this.jeuRepository = jeuRepository;
    }

    public void save(Jeu jeu){
        jeuRepository.save(jeu);
    }

    public List<Jeu> findAll(){
        return jeuRepository.findAll();
    }

    public Jeu findById(Long id) {
        return jeuRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        jeuRepository.deleteById(id);
    }

    public List<Jeu> findByTheme(Theme theme){
        return jeuRepository.findByTheme(theme);
    }
    public List<Jeu> findByGenre(Genre genre){
        return jeuRepository.findByGenre(genre);
    }
    public List<Jeu> findByType(Type type){
        return jeuRepository.findByType(type);
    }
    public List<Jeu> findByEditeur(Editeur editeur){
        return jeuRepository.findByEditeur(editeur);
    }


}
