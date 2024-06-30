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
public class Task_attachment extends AbcEntity {
    @OneToOne
    private Task taskId;
    @OneToOne
    private Attachment attachmentId;
    private boolean pin_cover_image;
}
