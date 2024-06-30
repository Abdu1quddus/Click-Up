package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace_role extends AbcEntity {
    @OneToOne
    private Workspace workspaceId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String extends_role;
}
