package kirysay.spring.TestBoot.repository;

import kirysay.spring.TestBoot.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    Optional<MyUser> findByUserLogin(String user_login);
    Optional<MyUser> findByUserId(int userId);
}
