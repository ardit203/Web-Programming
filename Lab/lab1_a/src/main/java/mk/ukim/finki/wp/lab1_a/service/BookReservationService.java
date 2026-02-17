package mk.ukim.finki.wp.lab1_a.service;

import mk.ukim.finki.wp.lab1_a.model.BookReservation;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);
}
