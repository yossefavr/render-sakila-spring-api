package yossefavr.demo.sakila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yossefavr.demo.sakila.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
