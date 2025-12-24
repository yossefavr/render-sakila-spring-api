package yossefavr.demo.sakila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yossefavr.demo.sakila.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    // JPQL - חיפוש שחקנים לפי שם מלא (firstName + lastName)
    @org.springframework.data.jpa.repository.Query("SELECT a FROM Actor a WHERE CONCAT(a.firstName, ' ', a.lastName) = :fullName")
    java.util.List<Actor> findByFullName(@org.springframework.data.repository.query.Param("fullName") String fullName);

}
