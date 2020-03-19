package JeuApplication.repository;

import JeuApplication.entity.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SimpleRepository<T extends SimpleEntity> extends JpaRepository<T, Long> {

    List<T> findAll();

    Optional<T> findById(Long id);
}
