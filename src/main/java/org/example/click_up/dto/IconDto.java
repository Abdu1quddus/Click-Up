package org.example.click_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {
    private Long attachmentId;
    private String color;
    private String initialLetter;
    private String icon;
}
