package web.adminlicense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.adminlicense.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByName(String name);
}
