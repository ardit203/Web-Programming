package mk.ukim.finki.wp.lab2_a.repository;

import mk.ukim.finki.wp.lab2_a.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    public List<Author> findAll();
    public Optional<Author> findById(Long id);
}
