package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model;

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

    private VorgangId vorgangId;

    @Default
    final Tarifierungsergebnis tarifierung = new Tarifierungsergebnis();
}

