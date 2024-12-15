package Assignment3Q1.accolite.Library.Management.controller;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.entity.Rating;
import Assignment3Q1.accolite.Library.Management.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating leaveReview(@RequestBody Rating rating) {
        return ratingService.leaveReview(rating);
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getReviewsForBook(@PathVariable int bookId) {
        return ratingService.getReviewsForBook(bookId);
    }

    @GetMapping("/top-rated/")
    public List<Book> getTopRatedBooks() {
        return ratingService.getBooksSortedByRating();
    }
}
