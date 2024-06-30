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
public class Space extends AbcEntity {
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String color;
    @OneToOne
    private Workspace workspaceId;
    @Column(nullable = false)
    private String initialLetter;
    @OneToOne
    private Icon icon;
    @Column(nullable = false)
    private Long avatarId;
    @Column(nullable = false)
    private Long ownerId;
    @Column(nullable = false)
    private String accessType;
}
