package JeuApplication.service;

import JeuApplication.entity.Editeur;
import JeuApplication.repository.EditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditeurService {

    private final EditeurRepository editeurRepository;

    @Autowired
    public EditeurService(EditeurRepository editeurRepository) {
        this.editeurRepository = editeurRepository;
    }

    public void save(Editeur editeur){
        editeurRepository.save(editeur);
    }

    public List<Editeur> findAll(){
        return editeurRepository.findAll();
    }
}
