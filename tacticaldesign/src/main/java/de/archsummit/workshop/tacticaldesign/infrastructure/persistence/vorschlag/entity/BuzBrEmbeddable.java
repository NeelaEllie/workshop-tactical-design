package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuzBrEmbeddable {

    @Column(name = "buz_br_gewaehlt")
    private boolean gewaehlt;
    @Column(name = "buz_br_endalter_leistungsdauer")
    private Integer endalterLeistungsdauer;
    @Column(name = "buz_br_wunschrente")
    private Integer wunschrente;
    @Column(name = "buz_br_azubi_student")
    private boolean azubiStudent;
}
