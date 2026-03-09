package de.archsummit.workshop.tacticaldesign.infrastructure.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


class FrvEinstiegIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";

    @Test
    void testGetInitialenFrvVorschlag() {

        RestAssured.baseURI = BASE_URL;

        String vorgangId = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/einstieg/initialFrv")
                .then()
                .statusCode(200)
                .body("vorgangId.value", notNullValue())
                .body("tarif.wert", equalTo("FRV"))
                .body("tarif.frv", equalTo(true))
                .extract().body().path("vorgangId.value");

        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/vorschlaege/" + vorgangId)
                .then()
                .statusCode(200)
                .body("vorgangId.value", equalTo(vorgangId))
                .body("tarif", equalTo("FRV"))
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
                .body("wunschvorgabe.vorgabeart", equalTo("BEITRAG"))
                .body("wunschvorgabe.moeglicheVorgabearten", contains("BEITRAG"))
                .body("wunschvorgabe.ergaenzungszahlung.verfuegbar", equalTo(true))
                .body("typ",
                        equalTo("de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe"))
        ;
    }

}