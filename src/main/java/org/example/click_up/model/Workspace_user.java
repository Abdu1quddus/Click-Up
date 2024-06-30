package org.example.click_up.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace_user extends AbcEntity {

    @OneToMany
    private List<Workspace> workspaceId;
    @OneToMany
    private List<User> userId;
    @OneToMany
    private List<Workspace_role> workspace_roleId;
    private Timestamp data_invited;
    private Timestamp data_joined;
}
