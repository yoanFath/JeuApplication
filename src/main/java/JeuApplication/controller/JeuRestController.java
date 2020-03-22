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


    @PostMapping(value = {"delete/{sId}"})
    public ResponseEntity deleteJeu(@PathVariable String sId) {
        try {
            Long id = Long.parseLong(sId);
            System.out.println(id);
            Jeu o = jeuService.findById(id);
            if (o == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Jeu non trouvé, vérifiez que l'id correspond");
            }
            jeuService.delete(id);

            return ResponseEntity.ok("Jeu supprimé");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seul l'id doit etre envoyé dans le body.");

        }
    }

    @PostMapping(value = {"ajouter"})
    public ResponseEntity addJeu(@RequestBody JeuDAO jeudao) {
        Type type = typeService.findById(jeudao.getTypeId());
        Editeur editeur = editeurService.findById(jeudao.getEditeurId());
        Theme theme = themeService.findById(jeudao.getThemeId());
        Genre genre = genreService.findById(jeudao.getGenreId());

        if (jeudao.getNom_jeu() == null || jeudao.getNom_jeu().length() == 0 || theme == null || type == null ||
                editeur == null || genre == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur dans le formulaire !");
        } else {
            Jeu jeu = new Jeu(jeudao.getNom_jeu(), jeudao.getAge_minimum(), jeudao.getNombre_joueurs_minimum(), jeudao.getNombre_joueurs_maximum(), editeur, type, theme, genre); // COUCOU
            jeuService.save(jeu);
            return ResponseEntity.ok("Jeu ajouté");
        }
    }

    @PostMapping(value = {"modifier/{id}"})
    public ResponseEntity modifierJeu(@RequestBody JeuDAO jeudao, @PathVariable Long id) {
        Jeu jeu = jeuService.findById(id);

        Type type = typeService.findById(jeudao.getTypeId());
        Editeur editeur = editeurService.findById(jeudao.getEditeurId());
        Theme theme = themeService.findById(jeudao.getThemeId());
        Genre genre = genreService.findById(jeudao.getGenreId());

        if (jeudao.getNom_jeu() == null || jeudao.getNom_jeu().length() == 0 || theme == null || type == null ||
                editeur == null || genre == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur dans le formulaire !");
        } else {
            jeu.setNom_jeu(jeudao.getNom_jeu());
            jeu.setAge_minimum(jeudao.getAge_minimum());
            jeu.setNombre_joueurs_minimum(jeudao.getNombre_joueurs_minimum());
            jeu.setNombre_joueurs_maximum(jeudao.getNombre_joueurs_maximum());
            jeu.setEditeur(editeur);
            jeu.setType(type);
            jeu.setTheme(theme);
            jeu.setGenre(genre);

            jeuService.save(jeu);
            return ResponseEntity.ok("Jeu modifié");
        }
    }

    @GetMapping(value = {"get/{sId}"})
    public ResponseEntity getJeu(@PathVariable String sId) {
        try {
            Long id = Long.parseLong(sId);
            Jeu o = jeuService.findById(id);

            if (o == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Jeu non trouvé, vérifiez que l'id correspond");
            }

            return ResponseEntity.ok(o);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seul l'id doit etre envoyé dans le body.");

        }
    }
}
