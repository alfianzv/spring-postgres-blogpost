package training.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.blogpost.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String title);
    List<Post> findByAuthorContaining(String author);

    @Query("SELECT p FROM Post p JOIN Author a ON p.id = a.id")
    List<Post> findAllWithAuthor();

}
