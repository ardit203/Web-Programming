package mk.ukim.finki.wp.lab2_a.web.controller;

import mk.ukim.finki.wp.lab2_a.service.AuthorService;
import mk.ukim.finki.wp.lab2_a.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = {"/books", "/"})
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books", bookService.listAll());
        return "listBooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditForm(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double avgRating,
                       @RequestParam Long authorId){
        bookService.update(id, title, genre, avgRating, authorId);
        return "redirect:/books";
    }


    @GetMapping("/add-form")
    public String getAddForm(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping
    public String save(@RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double avgRating,
                       @RequestParam Long authorId){
        bookService.create(title, genre, avgRating, authorId);
        return "redirect:/books";
    }
}
