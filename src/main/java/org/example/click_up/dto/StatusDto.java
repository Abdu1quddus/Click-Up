package org.example.click_up.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Category;
import org.example.click_up.model.Project;
import org.example.click_up.model.Space;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
    private String name;
    private Long spaceId;
    private Long projectId;
    private Long categoryId;
    private String color;
}
