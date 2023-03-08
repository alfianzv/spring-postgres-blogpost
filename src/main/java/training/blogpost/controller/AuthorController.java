package training.blogpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.blogpost.model.Author;
import training.blogpost.repository.AuthorRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public ResponseEntity getAllAuthors() {
        return ResponseEntity.ok().body(authorRepository.findAll());
    }

    @PostMapping("/author")
    public ResponseEntity saveAuthor(@RequestBody Author author) {
        return ResponseEntity.ok().body(authorRepository.save(author));
    }
}
