package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.fondsauswahl;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Fondsauswahl {

    private Risikoerwartung risikoerwartung;
    private Integer wertsteigerungMinimum;
    private Integer wertsteigerungMittel;
    private Integer wertsteigerungMaximum;
    private Integer wertsteigerungIndividuell;

    private List<FondsAnteil> fondsAnteile = new ArrayList<>();
}
