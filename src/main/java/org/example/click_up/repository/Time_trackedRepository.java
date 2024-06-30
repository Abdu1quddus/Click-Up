package org.example.click_up.repository;

import org.example.click_up.model.Time_tracked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Time_trackedRepository extends JpaRepository<Time_tracked, Long> {
}
