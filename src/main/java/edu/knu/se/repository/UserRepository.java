package edu.knu.se.repository;


import edu.knu.se.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByUserid(Long id);
    boolean existsByUserid(Long id);
    void deleteByUserid(Long id);
    Optional<User> findByPasswd(String passwd);
    List<User> findAll();

}
