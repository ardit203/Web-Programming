package mk.ukim.finki.wp.lab1_a.repository;

import mk.ukim.finki.wp.lab1_a.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    List<Book> searchBooks(String text, Double rating);
}
