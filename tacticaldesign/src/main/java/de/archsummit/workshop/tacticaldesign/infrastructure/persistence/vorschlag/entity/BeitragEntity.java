package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BeitragEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zahlweise;
    private Double wunschbeitrag;
    private Double ergaenzungszahlung;

}
