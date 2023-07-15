package com.example.buoi5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    void delete(Optional<User> user);
//    @Override
//    Optional<User> findById(Long id);
//    User findUserByIdAndUsername(Long id, String username);

}
