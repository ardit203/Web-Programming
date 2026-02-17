package mk.ukim.finki.wp.lab2_a.service.impl;

import mk.ukim.finki.wp.lab2_a.model.Author;
import mk.ukim.finki.wp.lab2_a.model.Book;
import mk.ukim.finki.wp.lab2_a.repository.BookRepository;
import mk.ukim.finki.wp.lab2_a.service.AuthorService;
import mk.ukim.finki.wp.lab2_a.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Book create(String title, String genre, Double avgRating, Long authorId) {
        Author author = authorService.findById(authorId);

        Book book = new Book(title, genre, avgRating, author);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String title, String genre, Double avgRating, Long authorId) {
        Author author = authorService.findById(authorId);

        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);

        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(avgRating);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
