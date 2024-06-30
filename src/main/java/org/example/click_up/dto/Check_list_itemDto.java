package org.example.click_up.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.Check_list;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check_list_itemDto {
    private String name;
    private Long check_listId;
    private String resolved;
    private Long assigned_userId;
}
