package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FrvTarifierungsergebnisRoot implements BausteinRoot {

    private final AnwendungskontextService anwendungskontextService;
    private final FrvTarifierungsergebnisRepository repository;
    private final FrvTarifierungsergebnisVorbelegungHandler vorbelegungHandler;

    @Override
    public FrvTarifierungsergebnis getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
