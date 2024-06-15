package com.ui;

import com.core.models.dto.ContactDTO;
import com.ui.pages.ContactPage;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;
import static com.core.providers.TestDataGenerator.randomText;

public class AddContactTest extends TestBase{
    @Test
    public void addContact(){
        ContactDTO contactDTO = ContactDTO.builder().name(randomName()).lastName(randomLastName()).phone(randomPhone()).email(randomEmail()).address(randomLocation()).description(randomText()).build();
        new ContactPage(driver).navigateToAddPage().addContact(contactDTO).assertLastContact(contactDTO);
    }
}
