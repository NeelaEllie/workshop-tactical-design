package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseBuz {

    private boolean present;
    /** Endalter Leistungsdauer. */
    private Integer leistungsdauer;

    private Integer leistungsdynamikErhoehungProz;

    public boolean isPresent() {
        return present;
    }
}
