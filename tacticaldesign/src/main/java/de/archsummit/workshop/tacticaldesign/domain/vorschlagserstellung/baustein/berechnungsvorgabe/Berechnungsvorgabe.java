package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorschlagBaustein;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Berechnungsvorgabe implements VorschlagBaustein<Berechnungsvorgabe> {

    private VorgangId vorgangId;
    private boolean verfuegbar;
    private Tarif tarif = Tarif.FRV;
    @Builder.Default
    private Beitrag beitrag = new Beitrag();
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate geburtsdatum;
}
