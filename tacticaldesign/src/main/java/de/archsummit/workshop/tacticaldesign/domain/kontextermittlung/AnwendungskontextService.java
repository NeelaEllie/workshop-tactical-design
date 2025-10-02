package de.archsummit.workshop.tacticaldesign.domain.kontextermittlung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnwendungskontextService {

    private final AnwendungskontextRepository repository;

    public Anwendungskontext initFrv() {
        return repository.save(new Anwendungskontext(Tarif.createFrv()));
    }

    public Anwendungskontext initSbu() {
        return repository.save(new Anwendungskontext(Tarif.createSbu()));
    }

    public Anwendungskontext get(final VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseThrow(() -> new IllegalArgumentException("Anwendungskontext nicht gefunden"));
    }
}
