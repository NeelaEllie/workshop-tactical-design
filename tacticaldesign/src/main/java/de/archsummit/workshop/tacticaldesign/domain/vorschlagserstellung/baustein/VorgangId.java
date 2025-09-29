package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class VorgangId {

    private String value;

    public static VorgangId create() {
        return new VorgangId(java.util.UUID.randomUUID().toString());
    }
}
