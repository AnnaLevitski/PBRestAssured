package com.api;

import com.core.models.dto.ContactDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllContactsTests extends ContactController {
    @Test
    public void getAllContacts_success(){
        Assert.assertEquals(statusCodeGetAllContacts(urlContact),200);
        List<ContactDTO> list = getAllContactsList(urlContact);
        for (ContactDTO contact : list){
            Assert.assertNotNull(contact.getEmail());
        }
    }

}
