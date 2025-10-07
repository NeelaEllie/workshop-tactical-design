package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FrvTarifierungsergebnisService implements BausteinService {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final FrvTarifierungsergebnisRepository repository;
    private final FrvTarifierungsergebnisVorbelegungHandler vorbelegungHandler;

    @Override
    public FrvTarifierungsergebnis getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
