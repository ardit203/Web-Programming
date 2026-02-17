package mk.ukim.finki.wp.lab2_a.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab2_a.model.Author;
import mk.ukim.finki.wp.lab2_a.model.Book;
import mk.ukim.finki.wp.lab2_a.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init() {

        authors.add(new Author("George", "Orwell", "UK", "Essayist and novelist; political fiction."));
        books.add(new Book("1984", "Dystopian", 4.8, authors.get(authors.size() - 1)));

        authors.add(new Author("J.K.", "Rowling", "UK", "Fantasy author of the Harry Potter series."));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 4.7, authors.get(authors.size() - 1)));

        authors.add(new Author("J.R.R.", "Tolkien", "UK", "Philologist; epic high fantasy."));
        books.add(new Book("The Hobbit", "Fantasy", 4.8, authors.get(authors.size() - 1)));

        authors.add(new Author("Haruki", "Murakami", "Japan", "Magical realism with contemporary themes."));
        books.add(new Book("Kafka on the Shore", "Magical Realism", 4.4, authors.get(authors.size() - 1)));

        authors.add(new Author("Margaret", "Atwood", "Canada", "Explores power, society, and futures."));
        books.add(new Book("The Handmaid's Tale", "Dystopian", 4.6, authors.get(authors.size() - 1)));

        authors.add(new Author("Agatha", "Christie", "UK", "Mystery pioneer; Poirot & Marple."));
        books.add(new Book("Murder on the Orient Express", "Mystery", 4.5, authors.get(authors.size() - 1)));

        authors.add(new Author("Neil", "Gaiman", "UK", "Fantasy and myth-weaving."));
        books.add(new Book("American Gods", "Fantasy", 4.4, authors.get(authors.size() - 1)));

        authors.add(new Author("Brandon", "Sanderson", "USA", "Epic fantasy; deep worldbuilding."));
        books.add(new Book("Mistborn: The Final Empire", "Fantasy", 4.6, authors.get(authors.size() - 1)));

        authors.add(new Author("Albert", "Camus", "France", "Philosopher-novelist; absurdism."));
        books.add(new Book("The Stranger", "Philosophical Fiction", 4.2, authors.get(authors.size() - 1)));

        authors.add(new Author("Gabriel", "García Márquez", "Colombia", "Master of magical realism."));
        books.add(new Book("One Hundred Years of Solitude", "Magical Realism", 4.7, authors.get(authors.size() - 1)));

    }
}
