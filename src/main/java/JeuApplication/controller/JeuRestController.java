package JeuApplication.controller;

import JeuApplication.dao.JeuDAO;
import JeuApplication.entity.*;
import JeuApplication.service.*;
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
    private final EditeurService editeurService;
    private final ThemeService themeService;
    private final TypeService typeService;
    private final GenreService genreService;

    @Autowired
    public JeuRestController(JeuService jeuService, EditeurService editeurService, ThemeService themeService, TypeService typeService, GenreService genreService) {
        this.jeuService = jeuService;
        this.editeurService = editeurService;
        this.themeService = themeService;
        this.typeService = typeService;
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public List<Jeu> findAll(Model model) {
        return jeuService.findAll();
    }

    @PostMapping("/findWithFilter")
    public List<Jeu> findWithFilter(@RequestBody JeuDAO jeudao) {
        System.out.println(jeudao.toString());
        System.out.println(jeudao.getNombre_joueurs_minimum());

        Type type = typeService.findById(jeudao.getTypeId());
        Editeur editeur = editeurService.findById(jeudao.getEditeurId());
        Theme theme = themeService.findById(jeudao.getThemeId());
        Genre genre = genreService.findById(jeudao.getGenreId());
        System.out.println("JEUDAO " + jeudao + " " + jeudao.getGenreId());
        Integer ageMin = jeudao.getAge_minimum() == 0 ? null : jeudao.getAge_minimum();
        Integer nbJMin = jeudao.getNombre_joueurs_minimum()== 0 ? null : jeudao.getNombre_joueurs_minimum();
        Integer nbJMax = jeudao.getNombre_joueurs_maximum()== 0 ? null : jeudao.getNombre_joueurs_maximum();

        System.out.println(" liste param : " + type + " "+ editeur + " "+ theme + " "+ genre + " "
                + ageMin + " " + nbJMin + " "
                + nbJMax + " ");

        if(type == null && editeur== null && theme== null && genre== null && ageMin== null && nbJMax== null && nbJMin== null ){
            return jeuService.findAll();
        }

        return jeuService.findjeuxWithFilter(type, genre, theme, nbJMin,
                nbJMax, ageMin, editeur);
    }

    @PostMapping(value = {"delete/{sId}"})
    public ResponseEntity deleteJeu(@PathVariable String sId){
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
    public ResponseEntity addJeu(@RequestBody Jeu jeu){
        jeuService.save(jeu);
        return ResponseEntity.ok("Jeu ajoutée");
    }
}
