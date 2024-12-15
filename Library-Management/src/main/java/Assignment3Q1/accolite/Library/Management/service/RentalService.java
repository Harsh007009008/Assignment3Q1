package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Rental;
import Assignment3Q1.accolite.Library.Management.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }
    @Transactional
    public Rental rentBook(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Optional<Rental> extendRentalPeriod(int rentalId, LocalDate newReturnDate) {
        Optional<Rental> rental = rentalRepository.findById(rentalId);
        rental.ifPresent(r -> r.setReturnDate(newReturnDate));
        return rental.map(rentalRepository::save);
    }

    public void returnBook(int rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public Rental updateRental(int id, Rental updatedRental) {
        Optional<Rental> rentalOpt = rentalRepository.findById(id);
        if (rentalOpt.isPresent()) {
            Rental rental = rentalOpt.get();
            rental.setRentalDate(updatedRental.getRentalDate());
            rental.setReturnDate(updatedRental.getReturnDate());
            return rentalRepository.save(rental);
        }
        return null;
    }

    public void deleteRental(int id) {
        rentalRepository.deleteById(id);
    }
}
