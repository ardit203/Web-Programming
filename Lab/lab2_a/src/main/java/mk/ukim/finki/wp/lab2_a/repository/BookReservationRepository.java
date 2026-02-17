package mk.ukim.finki.wp.lab2_a.repository;

import mk.ukim.finki.wp.lab2_a.model.BookReservation;

public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}
