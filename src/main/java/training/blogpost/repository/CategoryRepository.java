package training.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.blogpost.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContaining(String name);
}
