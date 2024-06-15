package com.api;

import com.core.listeners.RetryAnalyzer;
import com.core.models.dto.ContactDTO;
import com.core.providers.CleanupProvider;
import com.core.providers.PropertiesProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static com.core.providers.TestDataGenerator.*;
import static com.core.providers.TestDataGenerator.randomText;

public class GetAllContactsTests extends ContactController {
    ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
    ContactDTO contactDTO2 = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
    ContactDTO contactDTO3 = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
    @BeforeClass
    public  void bc(){
        CleanupProvider.cleanUp();
        Assert.assertEquals(statusCodeAddContact(contactDTO), 200);
        Assert.assertEquals(statusCodeAddContact(contactDTO2), 200);
        Assert.assertEquals(statusCodeAddContact(contactDTO3), 200);

    }

    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void getAllContacts_success(){
        List<ContactDTO> list = getAllContactsList();
        String[] array = {contactDTO.getEmail(), contactDTO2.getEmail(), contactDTO3.getEmail()};
        int i = 0;
        for (ContactDTO contact : list){
            Assert.assertEquals(contact.getEmail(), array[i++]);
        }
    }

    @AfterClass
    public void ac(){
        CleanupProvider.cleanUp();
    }

}
