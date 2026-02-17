package mk.ukim.finki.wp.lab4_a.service;

import mk.ukim.finki.wp.lab4_a.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {
    public List<Author> findAll();
    public Author findById(Long id);
}
