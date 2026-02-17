package mk.ukim.finki.wp.lab4_a.repository;

import mk.ukim.finki.wp.lab4_a.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaSpecificationRepository<Book, Long> {
    List<Book> findAllByTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrAverageRatingGreaterThanEqual(String text1, String text2, double rating);

    List<Book> findAllByAuthor_Id(Long authorId);
}
