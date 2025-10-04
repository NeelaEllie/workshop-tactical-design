package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.*;
import org.springframework.stereotype.Component;

@Component
class SbuLaufzeitVorbelegung implements LaufzeitVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isSbu();
    }

    @Override
    public Laufzeit get(VorgangId vorgangId) {
        return Laufzeit.builder()
                .vorgangId(vorgangId)
                .beitragszahlung(Beitragszahlung.builder()
                        .art(ArtBeitragszahlungsdauer.LAUFZEIT)
                        .wert(30)
                        .build())
                .versicherungsdauer(Versicherungsdauer.builder()
                        .art(ArtVersicherungsdauer.LAUFZEIT)
                        .wert(30)
                        .build())
                .build();
    }
}
