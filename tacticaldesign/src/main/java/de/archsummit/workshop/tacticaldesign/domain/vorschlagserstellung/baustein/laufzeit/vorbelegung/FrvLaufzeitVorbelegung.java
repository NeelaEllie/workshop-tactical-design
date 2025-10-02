package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.*;

@Component
class FrvLaufzeitVorbelegung implements LaufzeitVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isFrv();
    }

    @Override
    public Laufzeit get(VorgangId vorgangId) {
        return Laufzeit.builder()
                .vorgangId(vorgangId)
                .beitragszahlung(Beitragszahlung.builder()
                        .art(ArtBeitragszahlungsdauer.ENDALTER)
                        .wert(65)
                        .build())
                .versicherungsdauer(Versicherungsdauer.builder()
                        .art(ArtVersicherungsdauer.LAUFZEIT)
                        .wert(30)
                        .build())
                .build();
    }
}
