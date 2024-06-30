package org.example.click_up.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Workspace;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {
    private String name;
    private String color;
    private Long workspaceId;
}
