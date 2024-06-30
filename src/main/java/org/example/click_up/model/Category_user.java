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
public class Category_user extends AbcEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Category categoryId;
    @OneToOne
    private User userId;
}
