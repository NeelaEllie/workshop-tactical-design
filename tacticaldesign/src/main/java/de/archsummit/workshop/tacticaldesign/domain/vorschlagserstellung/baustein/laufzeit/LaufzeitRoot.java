package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung.LaufzeitVorbelegungHandler;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LaufzeitRoot implements BausteinRoot {

    private final AnwendungskontextService anwendungskontextService;
    private final LaufzeitRepository repository;
    private final LaufzeitVorbelegungHandler vorbelegungHandler;

    @Override
    public Laufzeit getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
