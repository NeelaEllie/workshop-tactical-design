package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.vorbelegung;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuzVorbelegungHandler {

    private final List<BuzVorbelegung> vorbeleger;

    public Buz get(final Anwendungskontext anwendungskontext) {
        return vorbeleger.stream()
                .filter(v -> v.isZustaendigFuer(anwendungskontext))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Keine passende Buz Vorbelegung gefunden"))
                .get(anwendungskontext.getVorgangId());
    }
}
