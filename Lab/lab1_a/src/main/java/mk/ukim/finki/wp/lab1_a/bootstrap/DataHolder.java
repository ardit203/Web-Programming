package mk.ukim.finki.wp.lab1_a.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1_a.model.Book;
import mk.ukim.finki.wp.lab1_a.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init(){
        books.add(new Book("The Silent Forest", "Mystery", 4.2));
        books.add(new Book("Shadows of Tomorrow", "Science Fiction", 4.6));
        books.add(new Book("Love in Paris", "Romance", 3.9));
        books.add(new Book("The Art of War", "History", 4.8));
        books.add(new Book("Whispers of the Sea", "Adventure", 4.1));
        books.add(new Book("Mind Over Matter", "Psychology", 4.5));
        books.add(new Book("Cursed Kingdom", "Fantasy", 4.0));
        books.add(new Book("Journey to Mars", "Science Fiction", 4.4));
        books.add(new Book("The Lost Diary", "Drama", 3.7));
        books.add(new Book("Modern Economics Explained", "Education", 4.3));
    }
}
