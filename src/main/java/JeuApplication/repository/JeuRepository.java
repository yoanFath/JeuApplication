package JeuApplication.repository;

import JeuApplication.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

    List<Jeu> findByTheme(Theme theme);

    List<Jeu> findByGenre(Genre genre);

    List<Jeu> findByType(Type type);

    List<Jeu> findByEditeur(Editeur editeur);

    @Query("SELECT j FROM Jeu j WHERE (:type is null or j.type = :type) and " +
            "(:genre is null or j.genre = :genre) and (:theme is null or j.theme = :theme) and " +
            "(:nombre_joueurs_minimum is null or j.nombre_joueurs_minimum = :nombreJoueursMinimum) and " +
            "(:nombre_joueurs_maximum is null or j.nombre_joueurs_maximum = :nombre_joueurs_maximum) and " +
            "(:age_minimum is null or j.age_minimum = :age_minimum) and (:editeur is null or j.editeur = :editeur)")
    List<Jeu> findJeux(
            @Param("type") Type type, @Param("genre") Genre genre,
            @Param("theme") Theme theme, @Param("nombre_joueurs_minimum") Integer nombre_joueurs_minimum,
            @Param("nombre_joueurs_maximum") Integer nombre_joueurs_maximum, @Param("age_minimum") Integer age_minimum,
            @Param("editeur") Editeur editeur);
}
