package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import lombok.RequiredArgsConstructor;

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
