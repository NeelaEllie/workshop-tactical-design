package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrvTarifierungsergebnis implements VorschlagBaustein<FrvTarifierungsergebnis> {

    private VorgangId vorgangId;
    private boolean verfuegbar;

    private Double garantierteRenteGemZahlweise;
    private Double garantiertesVertragsguthaben;
    private Double gesamtBeitragGemZahlweise;
}
