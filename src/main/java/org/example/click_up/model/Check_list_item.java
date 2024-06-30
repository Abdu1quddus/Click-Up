package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Check_list_item extends AbcEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Check_list check_listId;
    @Column(nullable = false)
    private String resolved;
    @Column(nullable = false)
    private Long assigned_userId;
}
