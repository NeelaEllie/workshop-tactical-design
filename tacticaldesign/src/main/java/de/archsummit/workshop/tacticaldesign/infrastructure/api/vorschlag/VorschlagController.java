package de.archsummit.workshop.tacticaldesign.infrastructure.api.vorschlag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vorschlaege")
@RequiredArgsConstructor
public class VorschlagController {

    private final VorschlagService vorschlagService;

    @GetMapping("/initial")
    public ResponseEntity<Vorschlag> getInitialenVorschlag() {
        Vorschlag saved = vorschlagService.erstelleNeuenVorschlag();
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{vorgangId}")
    public ResponseEntity<Vorschlag> getVorschlag(@PathVariable String vorgangId) {
        try {
            Vorschlag saved = vorschlagService.getVorschlag(new VorgangId(vorgangId));
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{vorgangId}/addBuzBr")
    public ResponseEntity<Vorschlag> addBuzBr(@PathVariable String vorgangId,
            @RequestBody BuzBrRequest buzBrRequest) {
        try {
            Vorschlag updated = vorschlagService.getVorschlag(new VorgangId(vorgangId));
            updated.fuegeBuzBerufHinzu(buzBrRequest.berufId());
            updated.fuegeBuzBrHinzu(buzBrRequest.wunschrente(), buzBrRequest.endalterLeistungsdauer(),
                    buzBrRequest.azubiStudent());
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{vorgangId}/validate")
    public ResponseEntity<ValidationResponse> validateVorschlag(@PathVariable String vorgangId) {
        try {
            vorschlagService.validiereVorschlag(new VorgangId(vorgangId));
            return ResponseEntity.ok(new ValidationResponse(Status.OK, "Vorschlag ist valide"));
        } catch (ValidierungException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ValidationResponse(Status.VALIDATION_ERROR, e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}