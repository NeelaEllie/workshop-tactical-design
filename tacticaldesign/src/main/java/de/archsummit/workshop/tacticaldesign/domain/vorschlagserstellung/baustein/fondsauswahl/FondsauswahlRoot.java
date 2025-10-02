package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung.FondsauswahlVorbelegungHandler;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FondsauswahlRoot implements BausteinRoot {

    private final AnwendungskontextService anwendungskontextService;
    private final FondsauswahlRepository repository;
    private final FondsauswahlVorbelegungHandler vorbelegungHandler;

    @Override
    public Fondsauswahl getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
