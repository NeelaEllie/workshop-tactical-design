package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung.LaufzeitVorbelegungHandler;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LaufzeitRoot implements BausteinRoot {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final LaufzeitRepository repository;
    private final LaufzeitVorbelegungHandler vorbelegungHandler;

    @Override
    public Laufzeit getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseGet(() -> create(vorgangId));
    }

    private Laufzeit create(VorgangId vorgangId) {
        Laufzeit laufzeit = vorbelegungHandler.get(anwendungskontextService.get(vorgangId));
        return repository.save(laufzeit);
    }
}
