package rest.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DataProvider {
    private static final RequestSpecification specification;
    private static final String API_BASE = "https://reqres.in";
    static{
        specification = new RequestSpecBuilder().setBaseUri(API_BASE).build();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    public Map getRestDataMap(String bodyPath){
        return given().spec(specification)
                .when()
                .get(bodyPath)
                .then()
                .statusCode(AppHttpStatusCode.OK.getCode())
                .extract().response().jsonPath().get();
    }
    public List getRestDataArray(String bodyPath){
        return given().spec(specification)
                .when()
                .get(bodyPath)
                .then()
                .statusCode(AppHttpStatusCode.OK.getCode())
                .extract().response().jsonPath().get();


    }
}
