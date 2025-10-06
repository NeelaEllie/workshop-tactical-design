package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VorschlagService {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final VorschlagVorbelegung vorbeleger;
    private final VorschlagRepository vorschlagRepository;

    public Vorschlag erstelleNeuenVorschlag(final VorgangId vorgangId) {
        final var vorschlag = vorbeleger.get(anwendungskontextService.get(vorgangId));
        return vorschlagRepository.save(vorschlag);
    }

    public Vorschlag getVorschlag(final VorgangId vorgangId) {
        return vorschlagRepository.get(vorgangId)
                .orElseThrow(() -> new IllegalArgumentException("Vorschlag nicht gefunden"));
    }
}
