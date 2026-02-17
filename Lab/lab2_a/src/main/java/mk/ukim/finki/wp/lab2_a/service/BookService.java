package mk.ukim.finki.wp.lab2_a.service;

import mk.ukim.finki.wp.lab2_a.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    Book findById(Long id);
    Book create(String title, String genre, Double avgRating, Long authorId);
    Book update(Long id, String title, String genre, Double avgRating, Long authorId);
    void delete(Long id);
}
