package mk.ukim.finki.wp.lab2_a.service;

import mk.ukim.finki.wp.lab2_a.model.BookReservation;


public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);
}
