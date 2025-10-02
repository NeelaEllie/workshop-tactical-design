package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu;

import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;
import lombok.RequiredArgsConstructor;

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
