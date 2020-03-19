package JeuApplication.service;

import JeuApplication.entity.Theme;
import JeuApplication.repository.ThemeRepository;
import org.springframework.stereotype.Service;

@Service
public class ThemeService extends SimpleService<Theme> {

    protected ThemeService(ThemeRepository repo) {
        super(repo);
    }
}
