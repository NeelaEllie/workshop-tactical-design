package de.archsummit.workshop.tacticaldesign.infrastructure.api.vorschlag;

import java.util.List;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VorschlagResponse {

    private Vorschlag vorschlag;
    private List<VorschlagBaustein> bausteine;
}
