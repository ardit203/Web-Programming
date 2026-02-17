package mk.ukim.finki.wp.lab3_a.web.controller;

import mk.ukim.finki.wp.lab3_a.model.Author;
import mk.ukim.finki.wp.lab3_a.model.Book;
import mk.ukim.finki.wp.lab3_a.service.AuthorService;
import mk.ukim.finki.wp.lab3_a.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
