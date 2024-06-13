package com.ui;

import org.testng.annotations.Test;


public class RemoveContactTest extends TestBase{

    @Test
    public void removeOneContact(){
        new TestBase().getHelperContact().removeContact();
    }


}
