package de.archsummit.workshop.tacticaldesign.domain.kontextermittlung;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.Data;

@Data
public class Anwendungskontext {

    private final VorgangId vorgangId;
    private final Tarif tarif;

    public Anwendungskontext(Tarif tarif) {
        this.tarif = tarif;
        vorgangId = VorgangId.create();
    }

    public Anwendungskontext(VorgangId vorgangId, Tarif tarif) {
        this.vorgangId = vorgangId;
        this.tarif = tarif;
    }
}
