package org.example.click_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;
    private String description;
    private Long statusId;
    private Long categoryId;
    private Long priorityId;
    private Long parentTaskId;
    private Long estimateTime;
}
