package de.archsummit.workshop.tacticaldesign.infrastructure.api.vorschlag;

public record BuzBrRequest(
        String berufId,
        Integer endalterLeistungsdauer,
        Integer wunschrente,
        Boolean azubiStudent
) {

}
