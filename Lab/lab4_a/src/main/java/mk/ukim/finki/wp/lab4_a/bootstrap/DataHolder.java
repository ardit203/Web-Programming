package mk.ukim.finki.wp.lab4_a.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab4_a.model.Author;
import mk.ukim.finki.wp.lab4_a.model.Book;
import mk.ukim.finki.wp.lab4_a.repository.AuthorRepository;
import mk.ukim.finki.wp.lab4_a.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataHolder(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void init() {

        if(authorRepository.findAll().isEmpty()){
            authors.add(new Author(
                    "John", "Miller", "USA",
                    "Contemporary fiction author focused on small-town stories and family dynamics."
            ));
            authors.add(new Author(
                    "Anastasija", "Petrova", "Russia",
                    "Writes psychological thrillers with complex characters and dark twists."
            ));
            authors.add(new Author(
                    "Marcus", "Lee", "UK",
                    "Specializes in epic fantasy worlds with detailed lore and magic systems."
            ));
            authors.add(new Author(
                    "Amina", "Hassan", "Egypt",
                    "Author of historical novels centered around ancient civilizations."
            ));
            authors.add(new Author(
                    "Sofia", "Rossi", "Italy",
                    "Romance writer known for emotional stories set in Mediterranean cities."
            ));
            authors.add(new Author(
                    "Kenji", "Tanaka", "Japan",
                    "Science fiction author blending technology, AI and human emotions."
            ));
            authors.add(new Author(
                    "Maria", "Gonzalez", "Spain",
                    "Writes literary fiction with strong social and political themes."
            ));
            authors.add(new Author(
                    "Oliver", "Schmidt", "Germany",
                    "Non-fiction and self-help writer focused on productivity and habits."
            ));
            authors.add(new Author(
                    "Lara", "Novak", "Croatia",
                    "Young adult author exploring coming-of-age themes and friendships."
            ));
            authors.add(new Author(
                    "Noah", "Anderson", "Canada",
                    "Mystery and crime novelist with intricate plots and clever detectives."
            ));

            authorRepository.saveAll(authors);
        }

        if(bookRepository.findAll().isEmpty()){
            books.add(new Book("Whispers of the River", "Drama", 4.3, authors.get(0)));
            books.add(new Book("Broken Autumn", "Contemporary", 4.1, authors.get(0)));

            books.add(new Book("Shadows in the Snow", "Thriller", 4.7, authors.get(1)));
            books.add(new Book("The Last Witness", "Crime/Thriller", 4.5, authors.get(1)));

            books.add(new Book("Kingdom of Ember", "Fantasy", 4.8, authors.get(2)));
            books.add(new Book("Blades of the Fallen", "Fantasy", 4.6, authors.get(2)));

            books.add(new Book("Daughter of the Nile", "Historical Fiction", 4.4, authors.get(3)));
            books.add(new Book("The Pharaoh’s Secret", "Historical Fiction", 4.2, authors.get(3)));

            books.add(new Book("Midnight in Florence", "Romance", 4.0, authors.get(4)));
            books.add(new Book("Letters by the Sea", "Romance", 4.3, authors.get(4)));

            books.add(new Book("Neon Skies", "Science Fiction", 4.6, authors.get(5)));
            books.add(new Book("Echoes of Tomorrow", "Science Fiction", 4.5, authors.get(5)));

            books.add(new Book("The Silent Protest", "Literary Fiction", 4.1, authors.get(6)));
            books.add(new Book("Walls of Glass", "Literary Fiction", 4.2, authors.get(6)));

            books.add(new Book("Focus in 5 Minutes", "Self-Help", 3.9, authors.get(7)));
            books.add(new Book("Habits that Last", "Self-Help", 4.2, authors.get(7)));

            books.add(new Book("Summer of the Lake", "Young Adult", 4.0, authors.get(8)));
            books.add(new Book("Between Two Worlds", "Young Adult", 4.1, authors.get(8)));

            books.add(new Book("The Missing Key", "Mystery", 4.4, authors.get(9)));
            books.add(new Book("Footprints at Midnight", "Crime/Mystery", 4.3, authors.get(9)));

            bookRepository.saveAll(books);
        }


    }
}
