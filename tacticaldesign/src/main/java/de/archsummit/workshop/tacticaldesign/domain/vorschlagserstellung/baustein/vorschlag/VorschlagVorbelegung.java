package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VorschlagVorbelegung {

    public Vorschlag get(final Anwendungskontext anwendungskontext) {
        return Vorschlag.builder()
                .vorgangId(anwendungskontext.getVorgangId())
                .tarif(Tarif.valueOf(anwendungskontext.getTarif().getWert().name()))
                .tarifierung(Tarifierungsergebnis.builder().valide(false).build())
                .build();
    }
}
