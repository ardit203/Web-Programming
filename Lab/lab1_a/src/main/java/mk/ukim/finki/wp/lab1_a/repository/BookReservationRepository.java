package mk.ukim.finki.wp.lab1_a.repository;

import mk.ukim.finki.wp.lab1_a.model.BookReservation;

public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}
