package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import org.springframework.stereotype.Component;

@Component
class BuzVerfuegbarVorbelegung implements BuzVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isFrv() && kontext.getTarif().isSbu();
    }

    @Override
    public Buz get(VorgangId vorgangId) {
        return Buz.builder()
                .vorgangId(vorgangId)
                .verfuegbar(true)
                .build();
    }
}
