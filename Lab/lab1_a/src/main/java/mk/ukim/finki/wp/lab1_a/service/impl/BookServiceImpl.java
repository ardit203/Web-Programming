package mk.ukim.finki.wp.lab1_a.service.impl;

import mk.ukim.finki.wp.lab1_a.model.Book;
import mk.ukim.finki.wp.lab1_a.repository.BookRepository;
import mk.ukim.finki.wp.lab1_a.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }
}
