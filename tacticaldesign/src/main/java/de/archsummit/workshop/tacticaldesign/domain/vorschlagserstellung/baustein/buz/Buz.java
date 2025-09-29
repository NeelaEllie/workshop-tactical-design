package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buz implements VorschlagBaustein<Buz> {

    private VorgangId vorgangId;
    private boolean verfuegbar;
    @Builder.Default
    private BuzBf buzBf = new BuzBf();
    @Builder.Default
    private BuzBr buzBr = new BuzBr();
    private Beruf beruf = new Beruf();

    public boolean isPresent() {
        return buzBf.isGewaehlt() || buzBr.isGewaehlt();
    }
}
