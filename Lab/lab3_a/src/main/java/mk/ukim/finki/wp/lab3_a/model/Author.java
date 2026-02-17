package mk.ukim.finki.wp.lab3_a.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;

    public Author(String name, String surname, String country, String biography){
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }
}
