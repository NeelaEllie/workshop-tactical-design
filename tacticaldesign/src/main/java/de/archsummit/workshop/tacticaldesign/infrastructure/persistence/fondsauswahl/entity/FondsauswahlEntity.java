package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FondsauswahlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String vorgangId;
    private boolean verfuegbar;
    private String risikoerwartung;
    private Integer wertsteigerungMinimum;
    private Integer wertsteigerungMittel;
    private Integer wertsteigerungMaximum;
    private Integer wertsteigerungIndividuell;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fondsauswahl")
    private List<FondsAnteilEntity> fondsAnteile;

}
