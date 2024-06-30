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
public class Category extends AbcEntity {
    @Column(nullable = false,unique = true)
    private String name;
    @OneToOne
    private Project projectId;
    @Column(nullable = false)
    private String access_type;
    @Column(nullable = false)
    private String archived;
    @Column(nullable = false)
    private String color;

}
