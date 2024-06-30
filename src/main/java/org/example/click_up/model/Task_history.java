package org.example.click_up.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task_history extends AbcEntity {
    @OneToOne
    private Task taskId;
    @Column(nullable = false)
    private String Change_field_name;
    private Timestamp after;
    private Timestamp before;
    private Timestamp data;

}
