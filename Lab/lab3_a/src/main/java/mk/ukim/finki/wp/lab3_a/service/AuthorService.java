package mk.ukim.finki.wp.lab3_a.service;

import mk.ukim.finki.wp.lab3_a.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> findAll();
    public Author findById(Long id);
}
