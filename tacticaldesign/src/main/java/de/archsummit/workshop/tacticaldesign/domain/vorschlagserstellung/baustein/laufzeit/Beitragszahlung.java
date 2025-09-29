package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beitragszahlung {

    private ArtBeitragszahlungsdauer art;
    private Integer wert;

}
