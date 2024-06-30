package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag extends AbcEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @ManyToOne
    private Workspace workspaceId;
}
