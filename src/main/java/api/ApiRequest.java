package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
@Data
public abstract class ApiRequest {
    protected String url;
    protected String authToken;
    protected RequestSpecification requestSpecification;
    protected Response response;

    public ApiRequest(String url, String authToken) {
        this.url = url;
        this.authToken = authToken;
        this.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(url)
                .build();
    }

    private void logResponse() {
        log.warn("Response is:");
        log.warn(getResponse().getBody().asPrettyString());
        log.warn("Status code is {}", getResponse().getStatusCode());
    }

    protected Response get(String endPoint) {
        log.info("performed GET {}", endPoint);
        this.response = given()
                .spec(requestSpecification)
                .get(endPoint);
        logResponse();
        return this.response;
    }

    protected Response post(String endPoint, String body) {
        log.info("Performed post {}", endPoint);
        log.info("Body is {}", body);
        this.response = given()
                .spec(requestSpecification)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }

}
