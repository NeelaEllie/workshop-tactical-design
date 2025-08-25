package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.tarifierungsergebnis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifierungsergebnis {

    private Double garantierteRenteGemZahlweise;
    private Double garantiertesVertragsguthaben;
    private Double gesamtBeitragGemZahlweise;
}
