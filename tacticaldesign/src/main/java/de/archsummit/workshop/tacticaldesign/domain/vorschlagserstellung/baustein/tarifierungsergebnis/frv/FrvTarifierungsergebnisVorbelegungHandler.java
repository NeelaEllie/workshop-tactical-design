package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FrvTarifierungsergebnisVorbelegungHandler {

    public FrvTarifierungsergebnis get(final Anwendungskontext anwendungskontext) {
        if (anwendungskontext.getTarif().isFrv()) {
            return FrvTarifierungsergebnis.builder()
                    .vorgangId(anwendungskontext.getVorgangId())
                    .verfuegbar(true)
                    .build();
        } else {
            return FrvTarifierungsergebnis.builder()
                    .vorgangId(anwendungskontext.getVorgangId())
                    .verfuegbar(false)
                    .build();
        }
    }
}
