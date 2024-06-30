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
public class Task extends AbcEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToOne
    private Status status;
    @OneToOne
    private Category categoryId;
    @OneToOne

    private Priority priorityId;
    @Column(nullable = false)
    private Long parentTaskId;
    private Timestamp startedDate;
    private Timestamp startTimeHas;
    private Timestamp dueDate;
    private Timestamp dueTimeHas;
    @Column(nullable = false)
    private Long estimateTime;
    private Timestamp activedDate;
}
