package de.archsummit.workshop.tacticaldesign.infrastructure.api.vorschlag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.VorschlagService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Vorschlagvalidierung;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.Status;
import de.archsummit.workshop.tacticaldesign.infrastructure.api.ValidationResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vorschlaege")
@RequiredArgsConstructor
public class VorschlagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VorschlagController.class);
    private final VorschlagService vorschlagService;
    private final VorschlagApiAdapter adapter;
    private final Vorschlagvalidierung vorschlagvalidierung;

    @PutMapping("/{vorgangId}")
    public ResponseEntity<Vorschlag> getInitialenVorschlag(@PathVariable String vorgangId) {
        Vorschlag saved = vorschlagService.erstelleNeuenVorschlag(new VorgangId(vorgangId));
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{vorgangId}")
    public ResponseEntity<VorschlagResponse> getVorschlag(@PathVariable String vorgangId) {
        try {
            return ResponseEntity.ok(adapter.get(new VorgangId(vorgangId)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{vorgangId}/validate")
    public ResponseEntity<ValidationResponse> validateVorschlag(@PathVariable String vorgangId) {
        try {
            vorschlagvalidierung.validiere(new VorgangId(vorgangId));
            return ResponseEntity.ok(new ValidationResponse(Status.OK, "Vorschlag ist valide"));
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