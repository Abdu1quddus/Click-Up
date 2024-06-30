package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbcEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String original_name;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String content_type;

}




