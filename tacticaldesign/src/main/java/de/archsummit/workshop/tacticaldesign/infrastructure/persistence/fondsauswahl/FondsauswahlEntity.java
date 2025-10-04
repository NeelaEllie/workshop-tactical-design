package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class FondsauswahlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String risikoerwartung;
    private Integer wertsteigerungMinimum;
    private Integer wertsteigerungMittel;
    private Integer wertsteigerungMaximum;
    private Integer wertsteigerungIndividuell;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fondsauswahl")
    private List<FondsAnteilEntity> fondsAnteile;

}
