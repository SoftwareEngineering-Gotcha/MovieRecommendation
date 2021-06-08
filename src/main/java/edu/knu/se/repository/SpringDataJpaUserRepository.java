package edu.knu.se.repository;

import edu.knu.se.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    Optional<User> findByPasswd(String passwd);

    @Override
    boolean existsById(Long id);
}
