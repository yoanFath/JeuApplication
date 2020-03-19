package JeuApplication.service;

import JeuApplication.entity.Type;
import JeuApplication.repository.TypeRepositroy;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends SimpleService<Type> {

    protected TypeService(TypeRepositroy repo) {
        super(repo);
    }
}
