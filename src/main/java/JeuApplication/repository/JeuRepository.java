package JeuApplication.repository;

import JeuApplication.entity.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Long> {
}
