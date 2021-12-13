package userAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userAPI.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
}
