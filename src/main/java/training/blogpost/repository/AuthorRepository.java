package training.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.blogpost.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByUsernameContaining(String username);
}
