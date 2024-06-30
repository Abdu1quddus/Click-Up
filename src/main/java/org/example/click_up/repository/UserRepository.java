package org.example.click_up.repository;

import org.example.click_up.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndFullName(String email, String fullName);
}
