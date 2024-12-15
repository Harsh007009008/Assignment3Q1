package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.entity.Rating;
import Assignment3Q1.accolite.Library.Management.repository.BookRepository;
import Assignment3Q1.accolite.Library.Management.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    private BookRepository bookRepository;
    @Transactional
    public Rating leaveReview(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getReviewsForBook(int bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    public List<Book> getBooksSortedByRating() {
        return ratingRepository.findBooksByRating();
    }
}
