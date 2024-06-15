package com.core.providers;

import com.api.Token;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static com.core.utils.Constants.URL_API;
import static io.restassured.RestAssured.given;

public class CleanupProvider {
    static RequestSpecification requestSpecification;
    static String urlContact = "v1/contacts";

    private static Response deleteContact(String token, String id){
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization",token)
                .setContentType(ContentType.JSON)
                .build();
        return given()
                .spec(requestSpecification)
                .when()
                .delete(URL_API+urlContact+id)
                .thenReturn();
    }
    public static int cleanUp(){
        String token = Token.getCurrentToken();
        return deleteContact(token, "/clear").statusCode();
    }

}
