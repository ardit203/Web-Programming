package mk.ukim.finki.wp.lab3_a.service.impl;

import mk.ukim.finki.wp.lab3_a.model.Author;
import mk.ukim.finki.wp.lab3_a.model.Book;
import mk.ukim.finki.wp.lab3_a.repository.BookRepository;
import mk.ukim.finki.wp.lab3_a.service.AuthorService;
import mk.ukim.finki.wp.lab3_a.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static mk.ukim.finki.wp.lab3_a.service.FieldFilterSpecification.filterContainsText;
import static mk.ukim.finki.wp.lab3_a.service.FieldFilterSpecification.filterEquals;

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
    public Page<Book> find(String title, Long authorId, Integer pageNum, Integer pageSize) {
        System.out.printf("%s %d %d %d\n", title, authorId, pageNum, pageSize);
        Specification<Book> specification = Specification.allOf(
                filterContainsText(Book.class, "title", title),
                filterEquals(Book.class, "author.id", authorId)
        );

        return bookRepository.findAll(
                specification,
                PageRequest.of(
                        pageNum - 1,
                        pageSize,
                        Sort.by(Sort.Direction.DESC, "title"))
        );
    }


    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.findAllByTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrAverageRatingGreaterThanEqual(text, text, rating);
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
        bookRepository.deleteById(id);
    }
}
