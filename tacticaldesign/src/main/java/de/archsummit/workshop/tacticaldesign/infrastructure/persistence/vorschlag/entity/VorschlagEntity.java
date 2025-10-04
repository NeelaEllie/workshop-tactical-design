package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VorschlagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vorgangId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TarifierungsergebnisEntity tarifierungsergebnis;
}
