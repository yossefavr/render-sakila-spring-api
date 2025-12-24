package yossefavr.demo.sakila.repositories;

import yossefavr.demo.sakila.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    // JPQL:
    // שים לב שאנחנו משתמשים בשם המחלקה Film ולא בשם הטבלה film
    // ובשדה f.language.name שמגיע דרך הקשר שעשינו
    @Query("SELECT f FROM Film f WHERE f.language.name = :langName")
    List<Film> findByLanguageName(@Param("langName") String langName);

}
