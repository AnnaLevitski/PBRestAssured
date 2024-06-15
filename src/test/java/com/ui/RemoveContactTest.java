package com.ui;

import com.ui.pages.ContactPage;
import org.testng.annotations.Test;


public class RemoveContactTest extends TestBase{
    @Test
    public void removeOneContact(){
        new ContactPage(driver).removeContact();
    }
}
