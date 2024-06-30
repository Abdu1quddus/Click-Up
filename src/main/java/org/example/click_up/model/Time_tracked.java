package org.example.click_up.model;

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
public class Time_tracked extends AbcEntity {
    @OneToOne
    private Task taskId;
    private Timestamp started_at;
    private Timestamp stopped_at;
}
