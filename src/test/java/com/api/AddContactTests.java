package com.api;

import com.core.listeners.RetryAnalyzer;
import com.core.models.dto.ContactDTO;
import com.core.providers.CleanupProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;


public class AddContactTests extends ContactController {
    @Test(invocationCount = 10, retryAnalyzer = RetryAnalyzer.class)
    public void addContact_success(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 200);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void addContact_negativePhone(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhoneWrong()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 400);
        Assert.assertEquals(getErrorMessageContact(contactDTO), "{phone=Phone number must contain only digits! And length min 10, max 15!}");
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void addContact_negativeEmail(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmailWrongAT()).address(randomLocation()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 400);
        Assert.assertEquals(getErrorMessageContact(contactDTO), "{email=must be a well-formed email address}");
    }
    @Test
    public void addContact_negativeName(){
        ContactDTO contactDTO = ContactDTO.builder().lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 400);
        Assert.assertEquals(getErrorMessageContact(contactDTO), "{name=must not be blank}");
    }
    @Test
    public void addContact_negativeLastname(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 400);
        Assert.assertEquals(getErrorMessageContact(contactDTO), "{lastName=must not be blank}");
    }
    @Test
    public void addContact_negativeAddress(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).description(randomText()).build();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 400);
        Assert.assertEquals(getErrorMessageContact(contactDTO), "{address=must not be blank}");
    }

    @AfterClass
    public void ac(){
        CleanupProvider.cleanUp();
    }


}
