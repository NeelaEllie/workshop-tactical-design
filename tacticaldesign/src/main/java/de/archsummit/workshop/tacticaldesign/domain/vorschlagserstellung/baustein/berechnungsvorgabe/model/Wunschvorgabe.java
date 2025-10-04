package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wunschvorgabe {

    private boolean verfuegbar;
    private Zahlweise zahlweise;
    private Double wunschbetrag;
    private Vorgabeart vorgabeart;
    @Builder.Default
    private List<Vorgabeart> moeglicheVorgabearten = new ArrayList<>();

    @Builder.Default
    private Ergaenzungszahlung ergaenzungszahlung = new Ergaenzungszahlung();

    public enum Vorgabeart {
        BEITRAG, RENTE
    }
}

