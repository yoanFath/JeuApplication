package JeuApplication.repository;

import JeuApplication.entity.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepository extends JpaRepository<Editeur, Long> {
}
