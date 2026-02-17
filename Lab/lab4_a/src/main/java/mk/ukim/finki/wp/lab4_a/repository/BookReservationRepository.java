package mk.ukim.finki.wp.lab4_a.repository;

import mk.ukim.finki.wp.lab4_a.model.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {

}
