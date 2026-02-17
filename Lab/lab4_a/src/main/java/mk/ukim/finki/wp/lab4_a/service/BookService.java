package mk.ukim.finki.wp.lab4_a.service;

import mk.ukim.finki.wp.lab4_a.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    Page<Book> find(String title, Long authorId, Integer pageNum, Integer pageSize);
    List<Book> searchBooks(String text, Double rating);
    Book findById(Long id);
    Book create(String title, String genre, Double avgRating, Long authorId);
    Book update(Long id, String title, String genre, Double avgRating, Long authorId);
    void delete(Long id);
}
