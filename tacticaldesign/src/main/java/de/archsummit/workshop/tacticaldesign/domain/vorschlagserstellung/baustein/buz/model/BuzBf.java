package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class BuzBf extends BaseBuz {

    public BuzBf(boolean present, Integer endalterLeistungsdauer) {
        super(present, endalterLeistungsdauer);
    }
}
