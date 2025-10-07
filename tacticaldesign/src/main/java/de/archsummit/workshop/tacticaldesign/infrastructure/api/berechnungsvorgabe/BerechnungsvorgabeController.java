package de.archsummit.workshop.tacticaldesign.infrastructure.api.berechnungsvorgabe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.BerechnungsvorgabeService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.validierung.BerechnungVorgabeValidierung;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.Status;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.ValidationResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/berechnungsvorgabe")
@RequiredArgsConstructor
public class BerechnungsvorgabeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BerechnungsvorgabeController.class);
    private final BerechnungsvorgabeService root;
    private final BerechnungVorgabeValidierung validierung;

    @GetMapping("/{vorgangId}")
    public ResponseEntity<Berechnungsvorgabe> getBerechnungsvorgabe(@PathVariable String vorgangId) {
        try {
            Berechnungsvorgabe saved = root.getOrCreate(new VorgangId(vorgangId));
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{vorgangId}/validate")
    public ResponseEntity<ValidationResponse> validate(@PathVariable String vorgangId) {
        try {
            validierung.validiere(new VorgangId(vorgangId));
            return ResponseEntity.ok(new ValidationResponse(Status.OK, "Berechnungvorgabe ist valide"));
        } catch (ValidierungException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ValidationResponse(Status.VALIDATION_ERROR, e.getMessage()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}