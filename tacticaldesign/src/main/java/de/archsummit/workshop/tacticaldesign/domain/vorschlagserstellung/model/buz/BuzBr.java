package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz;

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
    private boolean berufsstarter;

    public BuzBr(boolean present, Integer leistungsdauer, Integer leistungsdynamikErhoehungProz, Integer wunschrente,
            boolean azubiStudent, boolean berufsstarter) {
        super(present, leistungsdauer, leistungsdynamikErhoehungProz);
        this.wunschrente = wunschrente;
        this.azubiStudent = azubiStudent;
        this.berufsstarter = berufsstarter;
    }
}
