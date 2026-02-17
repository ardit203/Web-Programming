package mk.ukim.finki.wp.lab1_a.repository.impl;

import mk.ukim.finki.wp.lab1_a.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1_a.model.BookReservation;
import mk.ukim.finki.wp.lab1_a.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {
    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.removeIf(b -> b.getBookTitle().equals(reservation.getBookTitle())
                && b.getReaderName().equals(reservation.getReaderName())
                && b.getReaderAddress().equals(reservation.getReaderAddress())
                && b.getNumberOfCopies().equals(reservation.getNumberOfCopies()));

        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
