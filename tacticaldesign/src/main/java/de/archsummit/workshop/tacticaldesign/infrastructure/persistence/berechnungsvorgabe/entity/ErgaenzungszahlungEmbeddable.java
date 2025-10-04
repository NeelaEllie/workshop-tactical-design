package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ErgaenzungszahlungEmbeddable {
    private boolean verfuegbar;
    private Double wert;
}