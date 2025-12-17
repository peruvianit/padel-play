package it.peruvianit.delegator.system.info.service;

import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class SystemInfoServiceTest {
    @Test
    void getSystemInfo_shouldReturnJson() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/system/info")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(notNullValue());
    }
}