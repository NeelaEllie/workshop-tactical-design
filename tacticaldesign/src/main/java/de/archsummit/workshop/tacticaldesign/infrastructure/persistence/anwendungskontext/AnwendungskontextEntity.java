package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.anwendungskontext;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AnwendungskontextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String vorgangId;
    private String tarif;
}