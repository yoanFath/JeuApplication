package JeuApplication.service;

import JeuApplication.entity.Editeur;
import JeuApplication.repository.EditeurRepository;
import org.springframework.stereotype.Service;

@Service
public class EditeurService extends SimpleService<Editeur> {

    protected EditeurService(EditeurRepository editeurRepository) {
        super(editeurRepository);
    }
}
