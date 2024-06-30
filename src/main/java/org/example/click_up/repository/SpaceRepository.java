package org.example.click_up.repository;

import org.example.click_up.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space,Long> {
    boolean existsByName(String name);
}
