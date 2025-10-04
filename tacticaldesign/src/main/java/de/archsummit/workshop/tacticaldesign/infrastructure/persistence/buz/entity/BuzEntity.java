package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BuzEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vorgangId;

    private boolean verfuegbar;

    @Embedded
    private BuzBfEmbeddable buzBf;
    @Embedded
    private BuzBrEmbeddable buzBr;
    @Embedded
    private BerufEmbeddable beruf;
}
