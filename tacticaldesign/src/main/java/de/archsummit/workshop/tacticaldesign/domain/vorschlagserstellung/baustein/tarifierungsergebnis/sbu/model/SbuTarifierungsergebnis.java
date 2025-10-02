package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model;

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
public class SbuTarifierungsergebnis implements VorschlagBaustein<SbuTarifierungsergebnis> {

    private VorgangId vorgangId;
    private boolean verfuegbar;

    private Double renteGemZahlweise;
    private Double gesamtBeitragGemZahlweise;
}
