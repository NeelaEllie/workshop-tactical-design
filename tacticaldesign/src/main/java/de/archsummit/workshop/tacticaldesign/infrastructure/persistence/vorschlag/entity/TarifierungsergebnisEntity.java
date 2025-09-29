package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TarifierungsergebnisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double garantierteRenteGemZahlweise;
    private Double garantiertesVertragsguthaben;
    private Double gesamtBeitragGemZahlweise;
}
