package org.example.click_up.repository;

import org.example.click_up.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    boolean existsByName(String name);

}
