package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class WunschvorgabeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean verfuegbar;
    private List<String> moeglicheVorgabearten;
    private String vorgabeart;
    private String zahlweise;
    private Double wunschbetrag;
    @Embedded
    private ErgaenzungszahlungEmbeddable ergaenzungszahlung;

}
