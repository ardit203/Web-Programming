package mk.ukim.finki.wp.lab1_a.service;

import mk.ukim.finki.wp.lab1_a.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
}
