package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VorschlagVorbelegung {

    private final List<VorschlagVorbelegung> vorbeleger;

    public Vorschlag get(final Anwendungskontext anwendungskontext) {
        return Vorschlag.builder()
                .vorgangId(anwendungskontext.getVorgangId())
                .tarifierung(Tarifierungsergebnis.builder().valide(false).build())
                .build();
    }
}
