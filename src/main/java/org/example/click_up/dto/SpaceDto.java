package org.example.click_up.dto;


import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Icon;
import org.example.click_up.model.Workspace;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {
    private String name;
    private String color;
    private Long workspaceId;
    private String initialLetter;
    private Long iconId;
    private Long avatarId;
    private Long ownerId;
    private String accessType;
}
