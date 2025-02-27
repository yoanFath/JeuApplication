package JeuApplication.controller;

import JeuApplication.entity.SimpleEntity;
import JeuApplication.service.SimpleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class SimpleController<T extends SimpleEntity> {
    protected SimpleService<T> service;

    public SimpleController(SimpleService<T> service){
        this.service = service;
    }

    @PostMapping(value = {"ajouter"})
    public ResponseEntity addEntity(@RequestBody String name){
        T newEntity = setName(name,createEntity());

        service.save(newEntity);

        return ResponseEntity.ok("Entité ajoutée");
    }

    @PostMapping(value = {"delete/{sId}"})
    public ResponseEntity deleteEntity(@PathVariable String sId){
        try{
            Long id = Long.parseLong(sId);
            System.out.println(id);
            T o = service.findById(id);
            System.out.println(o);
            if(o == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Entité non trouvé, vérifiez que l'id correspond");
            }
            deleteJeu(o);
            service.delete(id);

            return ResponseEntity.ok("Entité supprimée");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seul l'id doit etre envoyé dans le body.");

        }
    }

    @PostMapping(value = {"modifier/{id}"})
    public ResponseEntity modifierEntity(@PathVariable("id") Long id, @RequestBody String name){
        try{
            T o = service.findById(id);
            if(o == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Entité non trouvé, vérifiez que l'id correspond");
            }
            o = setName(name, o);
            service.save(o);
            return ResponseEntity.ok("Entité modifiée");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seul l'id doit etre envoyé dans le body.");

        }
    }

    @GetMapping("/all")
    public List<T> findAll(){
        return service.findAll();
    }

    protected abstract T setName(String name, T o);

    protected abstract T createEntity();

    protected abstract void deleteJeu(T o);
}
