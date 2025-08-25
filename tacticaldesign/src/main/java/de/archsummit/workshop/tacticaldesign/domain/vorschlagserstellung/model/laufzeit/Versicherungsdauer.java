package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.laufzeit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Versicherungsdauer {

    private ArtVersicherungsdauer artVersicherungsdauer;
    private Integer wert;
}
