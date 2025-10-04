package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
