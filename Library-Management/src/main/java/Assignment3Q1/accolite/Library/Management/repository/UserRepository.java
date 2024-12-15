package Assignment3Q1.accolite.Library.Management.repository;

import Assignment3Q1.accolite.Library.Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
