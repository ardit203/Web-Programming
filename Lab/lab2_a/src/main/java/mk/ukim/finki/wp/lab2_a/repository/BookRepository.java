package mk.ukim.finki.wp.lab2_a.repository;

import mk.ukim.finki.wp.lab2_a.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    List<Book> searchBooks(String text, Double rating);

    Book save(Book book);

    void delete(Long id);
}
