package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseBuz {

    private boolean gewaehlt;
    private Integer endalterLeistungsdauer;

}
