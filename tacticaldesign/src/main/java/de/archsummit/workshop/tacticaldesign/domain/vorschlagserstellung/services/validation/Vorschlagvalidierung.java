package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Vorschlagvalidierung {

    // TODO Aufgabenstellung zur Veranschaulichung: Bringe ein weiteres Produkt mit einem anderen Bezugsrecht und ohne BUZ rein

    private final VorschlagService service;

    public void validiereFrv(final VorgangId vorgangId) {
        final var vorschlag = service.getVorschlag(vorgangId);
        // validiere Versicherungsbeginn
        if (vorschlag.getVersicherungsbeginn() == null || vorschlag.getVersicherungsbeginn()
                .isBefore(LocalDate.now())) {
            throw new ValidationException("Versicherungsbeginn nicht valide");
        }
        // validiere Geburtsdatum
        if (vorschlag.getGeburtsdatum() == null) {
            throw new ValidationException("Geburtsdatum nicht valide");
        }

        validiereBeitrag(vorschlag);
    }

    private static void validiereBeitrag(Vorschlag vorschlag) {
        Beitrag beitrag = vorschlag.getBeitrag();
        if (beitrag == null) {
            throw new ValidationException("Beitrag nicht valide");
        }

        if (beitrag.getBeitragsZahlweise() == null) {
            throw new ValidationException("Beitragszahlweise nicht valide");
        }

        if (beitrag.getWunschbeitrag() == null) {
            throw new ValidationException("Wunschbeitrag nicht valide");
        }

    }
}
