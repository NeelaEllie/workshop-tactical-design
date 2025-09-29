package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.Fondsauswahl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Laufzeit implements VorschlagBaustein<Laufzeit> {

    private VorgangId vorgangId;
    private boolean verfuegbar;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate versicherungsbeginn;

    @Builder.Default
    private Versicherungsdauer versicherungsdauer = new Versicherungsdauer();

    @Builder.Default
    private Beitragszahlung beitragszahlung = new Beitragszahlung();

}
