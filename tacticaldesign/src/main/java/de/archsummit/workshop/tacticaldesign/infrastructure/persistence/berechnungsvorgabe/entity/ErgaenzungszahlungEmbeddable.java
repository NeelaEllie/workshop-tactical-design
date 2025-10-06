package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ErgaenzungszahlungEmbeddable {

    @Column(name = "ergaenzungszahlung_verfuegbar")
    private boolean verfuegbar;
    private Double wert;
}