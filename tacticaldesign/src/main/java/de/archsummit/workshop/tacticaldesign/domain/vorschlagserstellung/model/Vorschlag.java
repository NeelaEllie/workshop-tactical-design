package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.BuzBf;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.BuzBr;
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
    private final VorgangId vorgangId = new VorgangId();

    private Tarif tarif = Tarif.FRV;

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

    public void fuegeBuzBfHinzu(final Integer endalterLeistungsdauer) {
        BuzBf buzBf = buz.getBuzBf();
        buzBf.setPresent(true);
        buzBf.setEndalterLeistungsdauer(endalterLeistungsdauer);
    }

    public void fuegeBuzBrHinzu(final Integer wunschrente, final Integer endalterLeistungsdauer,
            final boolean azubiStudent) {
        BuzBr buzBr = buz.getBuzBr();
        buzBr.setPresent(true);
        buzBr.setEndalterLeistungsdauer(endalterLeistungsdauer);
        buzBr.setWunschrente(wunschrente);
        buzBr.setAzubiStudent(azubiStudent);
    }

    public void fuegeBuzBerufHinzu(final String berufId) {
        buz.getBeruf().setId(berufId);
    }
}

