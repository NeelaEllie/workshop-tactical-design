package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SbuTarifierungsergebnisVorbelegungHandler {

    public SbuTarifierungsergebnis get(final Anwendungskontext anwendungskontext) {
        if (anwendungskontext.getTarif().isSbu()) {
            return SbuTarifierungsergebnis.builder()
                    .vorgangId(anwendungskontext.getVorgangId())
                    .verfuegbar(true)
                    .build();
        } else {
            return SbuTarifierungsergebnis.builder()
                    .vorgangId(anwendungskontext.getVorgangId())
                    .verfuegbar(false)
                    .build();
        }
    }
}
