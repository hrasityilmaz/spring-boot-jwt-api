package art.timestop.todos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import art.timestop.todos.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
