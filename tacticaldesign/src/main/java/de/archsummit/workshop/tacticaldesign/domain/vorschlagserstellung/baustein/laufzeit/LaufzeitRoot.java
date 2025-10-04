package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung.LaufzeitVorbelegungHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
