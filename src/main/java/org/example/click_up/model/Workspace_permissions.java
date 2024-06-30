package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;
import org.example.click_up.model.temporale.Permission;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace_permissions extends AbcEntity {
    @OneToOne
    private Workspace_role workspace_roleId;
    @Column(nullable = false)
    private Permission permission;

}