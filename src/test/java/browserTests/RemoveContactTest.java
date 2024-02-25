package browserTests;

import api.AuthController;
import api.BaseApi;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class RemoveContactTest extends TestBase{

    @Test
    public void removeOneContact(){
        new TestBase().getHelperContact().removeContact();
    }


}
