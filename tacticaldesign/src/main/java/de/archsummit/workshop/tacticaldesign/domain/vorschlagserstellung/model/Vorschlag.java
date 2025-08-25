package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.fondsauswahl.FondsAuswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.laufzeit.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.tarifierungsergebnis.Tarifierungsergebnis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vorschlag {

    @Default
    private VorgangId vorgangId = new VorgangId();

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate versicherungsbeginn;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate geburtsdatum;

    @Default
    private Beitrag beitrag = new Beitrag();

    @Default
    private Laufzeit laufzeit = new Laufzeit();

    @Default
    private FondsAuswahl fondsAuswahl = new FondsAuswahl();

    @Default
    private Buz buz = new Buz();

    @Default
    private Tarifierungsergebnis tarifierungsergebnis = new Tarifierungsergebnis();
}

