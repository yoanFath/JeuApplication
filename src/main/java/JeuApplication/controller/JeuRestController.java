package JeuApplication.controller;

import JeuApplication.adapter.JeuAdapter;
import JeuApplication.dao.JeuDAO;
import JeuApplication.entity.Jeu;
import JeuApplication.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jeu")
public class JeuRestController {

    private final JeuService jeuService;

    @Autowired
    public JeuRestController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    @GetMapping("/all")
    public List<Jeu> findAll(Model model) {
        return jeuService.findAll();
    }

//    @PostMapping("/findWithFilter")
//    public List<Jeu> findWithFilter(@RequestBody FilterDAO filterdao) {
//
//        return jeuService.findWithFilter();
//    }

    @PostMapping(value = {"delete"})
    public ResponseEntity deleteJeu(@RequestBody String sId){
        try{
            Long id = Long.parseLong(sId);
            System.out.println(id);
            Jeu o = jeuService.findById(id);
            if(o == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Jeu non trouvé, vérifiez que l'id correspond");
            }
            jeuService.delete(id);

            return ResponseEntity.ok("Jeu supprimé");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seul l'id doit etre envoyé dans le body.");

        }
    }

    @PostMapping(value = {"ajouter"})
    public ResponseEntity addJeu(@RequestBody JeuDAO jeuDAO){
        Jeu jeu = JeuAdapter.adaptJeuDAOToJeu(jeuDAO);

        jeuService.save(jeu);

        return ResponseEntity.ok("Jeu ajoutée");
    }
}
