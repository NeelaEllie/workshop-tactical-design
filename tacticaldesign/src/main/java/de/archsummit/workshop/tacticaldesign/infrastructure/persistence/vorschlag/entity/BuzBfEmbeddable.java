package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuzBfEmbeddable {

    @Column(name = "buz_bf_gewaehlt")
    private boolean gewaehlt;
    @Column(name = "buz_bf_endalter_leistungsdauer")
    private Integer endalterLeistungsdauer;
}
