package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FondsAnteilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private FondsauswahlEntity fondsauswahl;
    private String isin;
    private Integer anteil;
}
