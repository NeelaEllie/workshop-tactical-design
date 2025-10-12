package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vorschlag {

    @Default
    private final VorgangId vorgangId = VorgangId.create();

    /**
     * Der Tarif wird beim Einstieg initial gesetzt. Es liegt damit ein anderes Szenario zugrunde, als bei den
     * produktübergreifenden Berechnungsvorgaben, die wiederkehrend angepasst werden können.
     */
    private Tarif tarif;

    @Default
    final Tarifierungsergebnis tarifierung = new Tarifierungsergebnis();
}

