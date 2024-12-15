package Assignment3Q1.accolite.Library.Management.repository;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameContaining(String bookName);
    List<Book> findByAuthorNameContaining(String authorName);
    List<Book> findByGenresGenreType(String genreType);
}
