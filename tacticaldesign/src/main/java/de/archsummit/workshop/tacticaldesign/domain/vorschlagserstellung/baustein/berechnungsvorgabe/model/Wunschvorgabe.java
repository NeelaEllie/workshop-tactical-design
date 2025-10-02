package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wunschvorgabe {

    private boolean verfuegbar;
    private Zahlweise zahlweise;
    private Double wunschbetrag;
    private Vorgabeart vorgabeart;
    private List<Vorgabeart> moeglicheVorgabearten = new ArrayList<>();

    @Builder.Default
    private Ergaenzungszahlung ergaenzungszahlung = new Ergaenzungszahlung();

    public enum Vorgabeart {
        BEITRAG, RENTE
    }
}

