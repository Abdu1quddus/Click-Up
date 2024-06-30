package org.example.click_up.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.click_up.model.temporale.AbcEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace extends AbcEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String initialLetter;

    @ManyToOne
    private User users;

    @OneToOne
    private Attachment avatarId;


}
