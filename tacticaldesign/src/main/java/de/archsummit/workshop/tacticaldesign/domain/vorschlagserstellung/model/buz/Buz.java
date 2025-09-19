package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buz {

    @Builder.Default
    private BuzBf buzBf = new BuzBf();
    @Builder.Default
    private BuzBr buzBr = new BuzBr();
    private Beruf beruf = new Beruf();

    public boolean isPresent() {
        return buzBf.isPresent() || buzBr.isPresent();
    }
}
