package Assignment3Q1.accolite.Library.Management.repository;

import Assignment3Q1.accolite.Library.Management.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
