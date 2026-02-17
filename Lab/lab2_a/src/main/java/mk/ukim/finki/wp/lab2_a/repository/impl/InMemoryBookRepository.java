package mk.ukim.finki.wp.lab2_a.repository.impl;

import mk.ukim.finki.wp.lab2_a.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2_a.model.Book;
import mk.ukim.finki.wp.lab2_a.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public Optional<Book> findById(Long id) {
        return DataHolder.books
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

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

    @Override
    public Book save(Book book) {
        delete(book.getId());
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(b -> b.getId().equals(id));
    }
}
