package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class BuzBr extends BaseBuz {

    private Integer wunschrente;
    private boolean azubiStudent;

    public BuzBr(boolean present, Integer endalterLeistungsdauer, Integer wunschrente,
            boolean azubiStudent) {
        super(present, endalterLeistungsdauer);
        this.wunschrente = wunschrente;
        this.azubiStudent = azubiStudent;
    }
}
