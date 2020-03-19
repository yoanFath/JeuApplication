package JeuApplication.service;

import JeuApplication.entity.SimpleEntity;
import JeuApplication.repository.SimpleRepository;

import java.util.List;

public class SimpleService<T extends SimpleEntity> {

    protected SimpleRepository<T> repository;

    protected SimpleService(SimpleRepository<T> repo){
        this.repository = repo;
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<T> findAll(){
       return repository.findAll();
    }

    public void save(T o){
        repository.save(o);
    }
}
