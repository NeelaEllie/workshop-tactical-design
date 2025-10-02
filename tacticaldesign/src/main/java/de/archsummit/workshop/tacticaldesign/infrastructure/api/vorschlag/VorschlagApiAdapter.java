package de.archsummit.workshop.tacticaldesign.infrastructure.api.vorschlag;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.VorschlagService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VorschlagApiAdapter {

    private final VorschlagService vorschlagService;
    private final List<BausteinRoot> bausteinRoots;
    private final BausteinRoot bausteinRoot;

    public VorschlagResponse get(final VorgangId vorgangId) {
        return new VorschlagResponse(vorschlagService.getVorschlag(vorgangId),
                bausteinRoots.stream().map(root -> root.getOrCreate(vorgangId)).toList()
        );
    }
}
