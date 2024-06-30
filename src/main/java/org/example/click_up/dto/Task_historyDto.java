package org.example.click_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Task;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_historyDto {
    private Long taskId;
    private String Change_field_name;
}
