package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.laufzeit;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LaufzeitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String vorgangId;
    private String versicherungsdauerArt;
    private Integer versicherungsdauerWert;
    private String beitragszahlungArt;
    private Integer beitragszahlungWert;
}
