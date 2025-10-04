package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Fondsauswahl implements VorschlagBaustein<Fondsauswahl> {

    private VorgangId vorgangId;
    private boolean verfuegbar;
    private Risikoerwartung risikoerwartung;
    private Integer wertsteigerungMinimum;
    private Integer wertsteigerungMittel;
    private Integer wertsteigerungMaximum;
    private Integer wertsteigerungIndividuell;
    @Builder.Default
    private List<FondsAnteil> fondsAnteile = new ArrayList<>();
}
