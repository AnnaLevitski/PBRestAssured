package api;

import DTO.AuthRequestDTO;
import DTO.ContactDTO;
import DTO.ErrorDto;
import DTO.GettAllContactsDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ContactController extends BaseApi{
    RequestSpecification requestSpecification;
    public static String token;
    @BeforeSuite
    public void bs(){
         token = getTokenAuth();
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization",token)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static String urlContact = "v1/contacts";
    private Response addContact(ContactDTO contactDTO, String url){
        return given()
                .spec(requestSpecification)
                .body(contactDTO)
                .when()
                .post(baseURL+url)
                .thenReturn();
    }
    private Response getAllContacts(String url){
        return given()
                .spec(requestSpecification)
                .when()
                .get(baseURL+url)
                .thenReturn();
    }
    public List<ContactDTO> getAllContactsList(String url){
        return getAllContacts(url).getBody().as(GettAllContactsDTO.class).getContacts();
    }
    public int statusCodeAddContact(ContactDTO contactDTO, String url){
        return addContact(contactDTO,url).statusCode();
    }
    public int statusCodeGetAllContacts(String url){
        return getAllContacts(url).statusCode();
    }
    public String getMessageContact(ContactDTO contactDTO, String url){
        return String.valueOf(addContact(contactDTO,url).getBody().as(ErrorDto.class).getMessage());
    }

}
