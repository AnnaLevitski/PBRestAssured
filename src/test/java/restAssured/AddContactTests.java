package restAssured;

import DTO.*;
import api.ContactController;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddContactTests extends ContactController {
    @Test(invocationCount = 10)
    public void addContact_success(){
        ContactDTO contactDTO = ContactDTO.builder().id("dsf").name("Sara"+randomInt()).lastName("J"+randomInt()).phone("12345678"+randomInt()+"").email("sara"+randomInt()+"@gmail.com").address("NY "+randomInt()).description("ffd").build();
        Assert.assertEquals(statusCodeAddContact(contactDTO, urlContact), 200);
    }
    @Test
    public void addContact_negativePone(){
        ContactDTO contactDTO = ContactDTO.builder().id("dsf").name("Sara"+randomInt()).lastName("J"+randomInt()).phone(""+randomInt()).email("sara"+randomInt()+"@gmail.com").address("NY "+randomInt()).description("ffd").build();
        Assert.assertEquals(statusCodeAddContact(contactDTO, urlContact), 400);
        Assert.assertEquals(getMessageContact(contactDTO, urlContact), "{phone=Phone number must contain only digits! And length min 10, max 15!}");
    }
}
