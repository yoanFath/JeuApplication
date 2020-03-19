package JeuApplication.controller;

import JeuApplication.entity.Type;
import JeuApplication.service.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type")
public class TypeRestController extends SimpleController<Type> {

    public TypeRestController(TypeService service) {
        super(service);
    }

    @Override
    protected Type setName(String name, Type o) {
        o.setNom_type(name);
        return o;
    }

    @Override
    protected Type createEntity() {
        return new Type();
    }
}
