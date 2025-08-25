package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class VorgangId {

    private String value;

    public VorgangId() {
        this.value = java.util.UUID.randomUUID().toString();
    }
}
