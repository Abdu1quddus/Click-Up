package org.example.click_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Workspace;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_roleDto {
    private Long workspaceId;
    private String name;
    private String extends_role;
}
