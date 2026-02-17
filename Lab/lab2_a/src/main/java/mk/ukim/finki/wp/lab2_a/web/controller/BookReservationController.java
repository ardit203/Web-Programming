package mk.ukim.finki.wp.lab2_a.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab2_a.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String placeReservation(@RequestParam String readerName,
                                   @RequestParam String readerAddress,
                                   @RequestParam Integer numCopies,
                                   @RequestParam String bookTitle,
                                   Model model,
                                   HttpServletRequest req){

        model.addAttribute("readerName", readerName);
        model.addAttribute("ipAddress", req.getRemoteAddr());
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("numCopies", numCopies);

        bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);

        return "reservationConfirmation";
    }
}
