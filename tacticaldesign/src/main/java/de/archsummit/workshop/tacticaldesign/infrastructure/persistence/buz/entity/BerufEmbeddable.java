package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BerufEmbeddable {

    private String berufId;
}
