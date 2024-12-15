package Assignment3Q1.accolite.Library.Management.repository;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT r.book FROM Rating r GROUP BY r.book ORDER BY AVG(r.rating) DESC")
    List<Book> findBooksByRating();
    List<Rating> findByBookId(int bookId);
}
