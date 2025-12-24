package yossefavr.demo.sakila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yossefavr.demo.sakila.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
