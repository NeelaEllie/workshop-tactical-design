package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.fondsauswahl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FondsAnteil {

    private String isin;
    private Integer anteil;

}
