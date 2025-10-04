package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.frv;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FrvTarifierungsergebnisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double garantierteRenteGemZahlweise;
    private Double garantiertesVertragsguthaben;
    private Double gesamtBeitragGemZahlweise;
}
