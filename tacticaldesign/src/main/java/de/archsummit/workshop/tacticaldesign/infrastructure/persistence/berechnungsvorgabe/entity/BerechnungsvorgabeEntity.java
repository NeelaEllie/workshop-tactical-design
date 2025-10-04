package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class BerechnungsvorgabeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vorgangId;

    private boolean verfuegbar;

    private LocalDate geburtsdatum;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private WunschvorgabeEntity wunschvorgabe;
}
