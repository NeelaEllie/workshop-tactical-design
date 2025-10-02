package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;

@Component
class FrvFondsauswahlVorbelegung implements FondsauswahlVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isFrv();
    }

    @Override
    public Fondsauswahl get(VorgangId vorgangId) {
        return Fondsauswahl.builder()
                .vorgangId(vorgangId)
                .verfuegbar(true)
                .wertsteigerungMinimum(2)
                .wertsteigerungMittel(4)
                .wertsteigerungMaximum(6)
                .build();
    }
}
