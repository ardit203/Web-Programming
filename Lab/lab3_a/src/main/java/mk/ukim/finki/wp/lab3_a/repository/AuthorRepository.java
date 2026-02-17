package mk.ukim.finki.wp.lab3_a.repository;

import mk.ukim.finki.wp.lab3_a.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
