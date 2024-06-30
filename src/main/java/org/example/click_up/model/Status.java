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
public class Status extends AbcEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Space spaceId;
    @OneToOne
    private Project projectId;
    @OneToOne
    private Category categoryId;
    @Column(nullable = false)
    private String color;
}
