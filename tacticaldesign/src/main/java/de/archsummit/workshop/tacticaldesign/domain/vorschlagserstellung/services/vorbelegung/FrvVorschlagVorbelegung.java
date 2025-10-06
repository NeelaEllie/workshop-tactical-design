package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.vorbelegung;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.Zahlweise;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.*;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;

@Component
public class FrvVorschlagVorbelegung {

    public Vorschlag create() {
        return Vorschlag.builder()
                .tarif(Tarif.FRV)
                .versicherungsbeginn(LocalDate.now().withDayOfMonth(1).plusMonths(1))
                .beitrag(Beitrag.builder()
                        .beitragsZahlweise(Zahlweise.MONATLICH)
                        .build())
                .laufzeit(Laufzeit.builder()
                        .beitragszahlung(Beitragszahlung.builder()
                                .art(ArtBeitragszahlungsdauer.ENDALTER)
                                .wert(65)
                                .build())
                        .versicherungsdauer(Versicherungsdauer.builder()
                                .art(ArtVersicherungsdauer.LAUFZEIT)
                                .wert(30)
                                .build())
                        .build())
                .fondsAuswahl(Fondsauswahl.builder()
                        .wertsteigerungMinimum(2)
                        .wertsteigerungMittel(4)
                        .wertsteigerungMaximum(6)
                        .build())
                .build();
    }
}
