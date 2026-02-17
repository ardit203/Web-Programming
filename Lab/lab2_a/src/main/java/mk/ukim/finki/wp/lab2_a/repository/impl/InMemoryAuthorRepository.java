package mk.ukim.finki.wp.lab2_a.repository.impl;

import mk.ukim.finki.wp.lab2_a.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2_a.model.Author;
import mk.ukim.finki.wp.lab2_a.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return DataHolder.authors
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }
}
