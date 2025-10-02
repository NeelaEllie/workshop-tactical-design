package de.archsummit.workshop.tacticaldesign.infrastructure.api.berechnungsvorgabe;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.BerechnungsvorgabeRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.Status;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.ValidationResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vorschlaege")
@RequiredArgsConstructor
public class BerechnungsvorgabeController {

    private final BerechnungsvorgabeRoot root;

    @GetMapping("/{vorgangId}")
    public ResponseEntity<Berechnungsvorgabe> getBerechnungsvorgabe(@PathVariable String vorgangId) {
        try {
            Berechnungsvorgabe saved = root.getOrCreate(new VorgangId(vorgangId));
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{vorgangId}/validate")
    public ResponseEntity<ValidationResponse> validateVorschlag(@PathVariable String vorgangId) {
        try {
            root.validiere(new VorgangId(vorgangId));
            return ResponseEntity.ok(new ValidationResponse(Status.OK, "Berechnungvorgabe ist valide"));
        } catch (ValidierungException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ValidationResponse(Status.VALIDATION_ERROR, e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}