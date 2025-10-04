package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import org.springframework.stereotype.Component;

@Component
class SbuFondsauswahlVorbelegung implements FondsauswahlVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isSbu();
    }

    @Override
    public Fondsauswahl get(VorgangId vorgangId) {
        return Fondsauswahl.builder()
                .vorgangId(vorgangId)
                .verfuegbar(false)
                .build();
    }
}
