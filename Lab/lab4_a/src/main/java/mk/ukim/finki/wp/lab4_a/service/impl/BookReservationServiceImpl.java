package mk.ukim.finki.wp.lab4_a.service.impl;

import mk.ukim.finki.wp.lab4_a.model.BookReservation;
import mk.ukim.finki.wp.lab4_a.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab4_a.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        return bookReservationRepository.save(new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies));
    }
}
