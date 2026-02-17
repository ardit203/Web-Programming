package mk.ukim.finki.wp.lab1_a.repository.impl;

import mk.ukim.finki.wp.lab1_a.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1_a.model.Book;
import mk.ukim.finki.wp.lab1_a.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books
                .stream()
                .filter(b -> b.getTitle().toLowerCase()
                        .contains(text.toLowerCase())
                        && b.getAverageRating() >= rating)
                .toList();
    }
}
