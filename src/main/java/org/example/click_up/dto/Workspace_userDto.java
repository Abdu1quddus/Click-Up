package org.example.click_up.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.User;
import org.example.click_up.model.Workspace;
import org.example.click_up.model.Workspace_role;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_userDto {

    private Long workspaceId;
    private Long userId;
    private Long workspace_roleId;

}
