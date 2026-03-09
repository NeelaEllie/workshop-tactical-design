package de.archsummit.workshop.tacticaldesign.application.kontextermittlung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnwendungskontextService implements VorschlagAnwendungskontextService {

    private final AnwendungskontextRepository repository;

    public Anwendungskontext initFrv() {
        return repository.save(new Anwendungskontext(Tarif.createFrv()));
    }

    public Anwendungskontext get(final VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseThrow(() -> new IllegalArgumentException("Anwendungskontext nicht gefunden"));
    }
}
