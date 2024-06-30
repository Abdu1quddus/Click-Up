package org.example.click_up.model;

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
public class Space_click_apps extends AbcEntity {
    @OneToOne
    private Space spaceId;
    @OneToOne
    private Click_apps click_appsId;
}
