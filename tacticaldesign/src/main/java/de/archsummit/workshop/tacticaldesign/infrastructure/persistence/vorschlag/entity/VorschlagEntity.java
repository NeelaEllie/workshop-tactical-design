package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class VorschlagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vorgangId;

    @Column
    private String tarif;

    @Column
    private LocalDate versicherungsbeginn;

    @Column
    private LocalDate geburtsdatum;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BeitragEntity beitrag;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private LaufzeitEntity laufzeit;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FondsauswahlEntity fondsAuswahl;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BuzEntity buz;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TarifierungsergebnisEntity tarifierungsergebnis;
}
