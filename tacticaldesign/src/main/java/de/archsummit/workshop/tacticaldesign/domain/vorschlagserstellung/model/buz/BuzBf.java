package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class BuzBf extends BaseBuz {

    public BuzBf(boolean present, Integer endalterLeistungsdauer) {
        super(present, endalterLeistungsdauer);
    }
}
