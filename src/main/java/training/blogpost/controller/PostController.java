package training.blogpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.blogpost.model.Post;
import training.blogpost.repository.AuthorRepository;
import training.blogpost.repository.CategoryRepository;
import training.blogpost.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public ResponseEntity getAllPosts() {
        List<Post> posts = postRepository.findAllWithAuthor();
        return ResponseEntity.ok().body(posts);
    }

    @PostMapping("/post")
    public ResponseEntity savePost(@RequestBody Post post) {

        authorRepository.save(post.getAuthor());
        return ResponseEntity.ok().body(postRepository.save(post));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElse(null );
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/post/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        List<Post> post = postRepository.findByTitleContaining(title);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/post/{author}")
    public ResponseEntity getPostByAuthor(@PathVariable String author) {
        List<Post> post = postRepository.findByAuthorContaining(author);
        return ResponseEntity.ok().body(post);
    }

}
