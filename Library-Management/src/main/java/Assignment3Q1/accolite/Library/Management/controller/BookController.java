package Assignment3Q1.accolite.Library.Management.controller;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.service.BookService;
import Assignment3Q1.accolite.Library.Management.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/book/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }

    @GetMapping("/genre/search")
    public List<Book> searchBooksByGenre(@RequestParam String query) {
        return bookService.searchBooksByGenre(query);
    }

    @GetMapping("/author/search")
    public List<Book> searchBooksByAuthor(@RequestParam String query){
        return  bookService.searchByAuthor(query);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody Book book) {
        System.out.println(book);
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
    @Autowired
    private RatingService ratingService;
    @GetMapping("/sorted-by-rating")
    public List<Book> getBooksSortedByRating() {
        return ratingService.getBooksSortedByRating();
    }
}
