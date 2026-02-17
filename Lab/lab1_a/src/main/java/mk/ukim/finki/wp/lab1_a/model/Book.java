package mk.ukim.finki.wp.lab1_a.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private Double averageRating;
}
