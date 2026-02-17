package mk.ukim.finki.wp.lab3_a.repository;

import mk.ukim.finki.wp.lab3_a.model.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {

}
