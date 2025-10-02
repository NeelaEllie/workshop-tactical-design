package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vorschlag {

    @Default
    private final VorgangId vorgangId = VorgangId.create();

    @Default
    final Tarifierungsergebnis tarifierung = new Tarifierungsergebnis();
}

