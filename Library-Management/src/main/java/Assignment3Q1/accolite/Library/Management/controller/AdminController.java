package Assignment3Q1.accolite.Library.Management.controller;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.entity.User;
import Assignment3Q1.accolite.Library.Management.entity.Rental;
import Assignment3Q1.accolite.Library.Management.service.BookService;
import Assignment3Q1.accolite.Library.Management.service.UserService;
import Assignment3Q1.accolite.Library.Management.service.RentalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RentalService rentalService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public String createNodes(@RequestBody List<User> users) {
        for (User u : users) {
            System.out.println(u);
            userService.addUser(u);
        }
        return "user added successfully";
    }


    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    public User getUserDetails(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/rentals")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/rentals")
    public Rental addRental(@RequestBody Rental rental) {
        return rentalService.rentBook(rental);
    }

    @PutMapping("/rentals/{id}")
    public Rental updateRental(@PathVariable int id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }

    @DeleteMapping("/rentals/{id}")
    public void deleteRental(@PathVariable int id) {
        rentalService.deleteRental(id);
    }
}
