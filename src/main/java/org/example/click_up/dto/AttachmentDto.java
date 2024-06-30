package org.example.click_up.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AttachmentDto {
    private String name;
    private String original_name;
    private String size;
    private String content_type;
}
