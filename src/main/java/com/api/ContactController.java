package com.api;

import com.core.models.dto.ContactDTO;
import com.core.models.dto.ErrorDto;
import com.core.models.dto.GettAllContactsDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import static com.api.Token.getCurrentToken;
import static com.core.utils.Constants.URL_API;
import static io.restassured.RestAssured.given;

public class ContactController {
    static String urlContact = "v1/contacts";
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void bs(){

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization",getCurrentToken())
                .setContentType(ContentType.JSON)
                .build();
    }
    private Response addContact(ContactDTO contactDTO){
        return given()
                .spec(requestSpecification)
                .body(contactDTO)
                .when()
                .post(URL_API+urlContact)
                .thenReturn();
    }
    private Response getAllContacts(){
        return given()
                .spec(requestSpecification)
                .when()
                .get(URL_API+urlContact)
                .thenReturn();
    }
    public List<ContactDTO> getAllContactsList(){
        return getAllContacts().getBody().as(GettAllContactsDTO.class).getContacts();
    }
    public int statusCodeAddContact(ContactDTO contactDTO){
        return addContact(contactDTO).statusCode();
    }
    public int statusCodeGetAllContacts(){
        return getAllContacts().statusCode();
    }
    public String getMessageContact(ContactDTO contactDTO){
        return addContact(contactDTO).getBody().toString().split("@")[1];
    }
    public String getErrorMessageContact(ContactDTO contactDTO){
        return String.valueOf(addContact(contactDTO).getBody().as(ErrorDto.class).getMessage());
    }

}
