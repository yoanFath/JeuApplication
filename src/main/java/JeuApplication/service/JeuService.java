package JeuApplication.service;

import JeuApplication.entity.Jeu;
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
}
