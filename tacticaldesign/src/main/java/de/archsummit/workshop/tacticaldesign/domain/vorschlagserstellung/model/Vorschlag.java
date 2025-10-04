package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.BuzBf;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.buz.BuzBr;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.fondsauswahl.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.laufzeit.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.tarifierungsergebnis.Tarifierungsergebnis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Ein Vorschlag umfasst alle Merkmale eines Produktes. Die verschiedenen Vorgaben und Merkmale spielen eine direkte
 * Rolle für das Tarifierungsergebnis.
 * <p>
 * Als finales Ergebnisartefakt wird aus einem vollständigen Vorschlag aus gewählten Produktmerkmalen und dem
 * berechneten Tarifierungsergebnis ein Vorschlagsdokument erzeugt, welches als Kontextgrenze zur Antragserstellung
 * definiert werden kann.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vorschlag {

    /**
     * Eindeutige ID des Vorgangs, der übergreifend für die Vorschlags- und Antragserstellung gilt.
     */
    @Default
    private final VorgangId vorgangId = new VorgangId();

    /**
     * Der Tarif gibt das gewählte Produkt beim Einstieg wider. Er ist sowohl für die verfügbaren Produktmerkmale, als
     * auch für die relevanten Antragsbausteine entscheidend und wird üblicherweise nach dem Einstieg in einen Vorgang
     * nicht mehr angepasst.
     */
    private Tarif tarif = Tarif.FRV;

    /**
     * Der Versicherungsbeginn ist eine notwendige Vorgabe für jedes Produkt. Es gibt bestimmte fachliche Bedingungen
     * wie weit im Voraus oder wie weit zurück der Beginn einer Versicherung datiert werden darf. Basierend auf dem
     * Versicherungsbeginn können verschiedene Laufzeiten, wie Beitragszahlungsdauer und Versicherungsdauer berechnet
     * werden.
     */
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate versicherungsbeginn;

    /**
     * Das Geburtsdatum der versicherten Person ist für jedes Leben Produkt eine notwendige Vorgabe.
     */
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate geburtsdatum;

    /**
     * Der Beitrag ist eine notwendige Vorgabe für jedes Produkt, bei welchem das Tarifierungsergebnis basierend auf
     * einem Wunschbeitrag ermittelt wird.
     */
    @Default
    private Beitrag beitrag = new Beitrag();

    /**
     * Die Laufzeit umfasst verschiedene Laufzeiten einer Versicherung. Die Berechnung erfolgt über die Vorgabe des zu
     * erreichendem Alter, der Laufzeit in Jahren oder auch einer konkreten Jahreszahl. Zusammen mit dem
     * Versicherungsbeginn und in einigen Fällen des Geburtsdatums der versicherten Person werden die tatsächlichen
     * Laufzeiten nach produktübergreifenden Regeln ermittelt.
     */
    @Default
    private Laufzeit laufzeit = new Laufzeit();

    /**
     * Die ausgewählten Fonds oder Portfolios mit der resultierenden Risikobewertung und der Angabe welche
     * beispielhaften Wertsteigerungen bei der Tarifierung mit berechnet werden sollen. Die Fondsauswahl ist nur für
     * fondsgebundene Produkte relevant.
     */
    @Default
    private Fondsauswahl fondsAuswahl = new Fondsauswahl();

    /**
     * Die Berufsunfähigkeitszusatzversicherung, welche nur aus einer Beitragsbefreiung (BUZ-BF) oder aber aus einer
     * BU-Rente (BUZ-BR) bestehen kann. Diese Zusatzversicherung ist nur bei bestimmten Produkten relevant und hat
     * eigene Laufzeiten und Beiträge.
     */
    @Default
    private Buz buz = new Buz();

    /**
     * Das Ergebnis einer Tarifierung basierend auf allen gewählten Produktmerkmalen und Vorgaben. Das Ergebnis kann
     * auch nicht valide sein und transportiert in dem Falle Validierungsfehlermeldungen.
     * <p>
     * Die Zusammensetzung eines Tarifierungsergebnisses ist produktspezifisch.
     */
    @Default
    private Tarifierungsergebnis tarifierungsergebnis = new Tarifierungsergebnis();

    public void fuegeBuzBfHinzu(final Integer endalterLeistungsdauer) {
        BuzBf buzBf = buz.getBuzBf();
        buzBf.setGewaehlt(true);
        buzBf.setEndalterLeistungsdauer(endalterLeistungsdauer);
    }

    public void fuegeBuzBrHinzu(final Integer wunschrente, final Integer endalterLeistungsdauer,
                                final boolean azubiStudent) {
        BuzBr buzBr = buz.getBuzBr();
        buzBr.setGewaehlt(true);
        buzBr.setEndalterLeistungsdauer(endalterLeistungsdauer);
        buzBr.setWunschrente(wunschrente);
        buzBr.setAzubiStudent(azubiStudent);
    }

    public void fuegeBuzBerufHinzu(final String berufId) {
        buz.getBeruf().setId(berufId);
    }
}

