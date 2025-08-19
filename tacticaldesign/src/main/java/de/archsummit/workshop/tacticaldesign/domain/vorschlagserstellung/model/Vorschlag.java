package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
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

    @Default
    private Beitrag beitrag = new Beitrag();

    @Default
    private TarifierungEingabeDaten tarifierungEingabeDaten = new TarifierungEingabeDaten();

    @Default
    private Tarifierungsergebnis tarifierungsergebnis = new Tarifierungsergebnis();

    @Default
    private Buz buz = new Buz();
}

