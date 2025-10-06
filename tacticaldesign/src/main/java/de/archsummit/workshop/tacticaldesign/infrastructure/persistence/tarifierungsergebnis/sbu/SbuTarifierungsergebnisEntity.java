package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.sbu;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SbuTarifierungsergebnisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String vorgangId;
    private boolean verfuegbar;
    private Double renteGemZahlweise;
    private Double gesamtBeitragGemZahlweise;
}
