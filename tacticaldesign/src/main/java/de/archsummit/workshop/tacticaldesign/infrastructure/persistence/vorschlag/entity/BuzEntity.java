package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BuzEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private BuzBfEmbeddable buzBf;
    @Embedded
    private BuzBrEmbeddable buzBr;
    @Embedded
    private BerufEmbeddable beruf;
}
