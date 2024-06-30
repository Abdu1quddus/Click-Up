package org.example.click_up.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {
    private String name;
    private String color;
    private Long userId;
    private String initialLetter;
    private Long avatarId;
}
