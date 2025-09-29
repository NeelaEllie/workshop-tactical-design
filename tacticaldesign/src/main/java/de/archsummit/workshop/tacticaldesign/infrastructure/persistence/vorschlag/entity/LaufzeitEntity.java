package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LaufzeitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private VorschlagEntity vorschlag;
    private String versicherungsdauerArt;
    private Integer versicherungsdauerWert;
    private String beitragszahlungArt;
    private Integer beitragszahlungWert;
}
