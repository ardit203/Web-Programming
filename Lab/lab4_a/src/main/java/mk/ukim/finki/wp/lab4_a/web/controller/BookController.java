package mk.ukim.finki.wp.lab4_a.web.controller;

import mk.ukim.finki.wp.lab4_a.model.Author;
import mk.ukim.finki.wp.lab4_a.model.Book;
import mk.ukim.finki.wp.lab4_a.service.AuthorService;
import mk.ukim.finki.wp.lab4_a.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = {"/books"})
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String title,
                               @RequestParam(required = false) Long authorId,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pagSize,
                               Model model){

        Page<Book> books = bookService.find(title, authorId, pageNum, pagSize);
        model.addAttribute("page", books);

        model.addAttribute("title", title);
        model.addAttribute("authorId", authorId);

        List<Author> authors = authorService.findAll();
        System.out.println(authors);
        model.addAttribute("authors", authors);
        model.addAttribute("bodyContent", "listBooks");
        return "master-template";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.delete(id);
        return getBooksPage(null, null, 1, 10, model);
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditForm(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("bodyContent", "book-form");
        return "master-template";
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double avgRating,
                       @RequestParam Long authorId,
                       Model model){
        bookService.update(id, title, genre, avgRating, authorId);
        return getBooksPage(null, null, 1, 10, model);
    }


    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAddForm(Model model){
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("bodyContent", "book-form");
        return "master-template";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double avgRating,
                       @RequestParam Long authorId,
                       Model model){
        bookService.create(title, genre, avgRating, authorId);
        return getBooksPage(null, null, 1, 10, model);
    }
}
