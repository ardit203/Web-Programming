package mk.ukim.finki.wp.lab2_a.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String genre;
    private Double averageRating;
    private Author author;

    public Book(String title, String genre, Double averageRating, Author author){
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }
}
