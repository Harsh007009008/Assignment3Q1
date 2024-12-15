package Assignment3Q1.accolite.Library.Management.controller;

import Assignment3Q1.accolite.Library.Management.entity.Rental;
import Assignment3Q1.accolite.Library.Management.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;


    @PostMapping
    public Rental rentBook(@RequestBody Rental rental) {
        return rentalService.rentBook(rental);
    }

    @PutMapping("/extend/{id}")
    public Optional<Rental> extendRental(@PathVariable int id, @RequestParam LocalDate newReturnDate) {
        System.out.println("Rental ID: " + id);
        System.out.println("New Return Date: " + newReturnDate);
        return rentalService.extendRentalPeriod(id, newReturnDate);
    }


    @DeleteMapping("/{id}")
    public void returnBook(@PathVariable int id) {
        rentalService.returnBook(id);
    }
}
