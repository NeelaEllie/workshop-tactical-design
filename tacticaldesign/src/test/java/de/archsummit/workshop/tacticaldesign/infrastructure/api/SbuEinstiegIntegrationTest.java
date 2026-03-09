package de.archsummit.workshop.tacticaldesign.infrastructure.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


class SbuEinstiegIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";

    @Test
    void testGetInitialenSbuVorschlag() {

        RestAssured.baseURI = BASE_URL;

        String vorgangId = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/einstieg/initialSbu")
                .then()
                .statusCode(200)
                .body("vorgangId.value", notNullValue())
                .body("tarif.wert", equalTo("SBU"))
                .body("tarif.sbu", equalTo(true))
                .extract().body().path("vorgangId.value");

        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/vorschlaege/" + vorgangId)
                .then()
                .statusCode(200)
                .body("vorgangId.value", equalTo(vorgangId))
                .body("tarif", equalTo("SBU"))
                .body("tarifierung.valide", equalTo(false));

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/berechnungsvorgabe/" + vorgangId)
                .then()
                .statusCode(200)
                .body("vorgangId.value", equalTo(vorgangId))
                .body("verfuegbar", equalTo(true))
                .body("wunschvorgabe.verfuegbar", equalTo(true))
                .body("wunschvorgabe.zahlweise", equalTo("MONATLICH"))
                .body("wunschvorgabe.vorgabeart", equalTo("RENTE"))
                .body("wunschvorgabe.moeglicheVorgabearten", contains("BEITRAG", "RENTE"))
                .body("wunschvorgabe.ergaenzungszahlung.verfuegbar", equalTo(false))
                .body("typ",
                        equalTo("de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe"))
        ;
    }

}