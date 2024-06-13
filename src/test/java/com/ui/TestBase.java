package com.ui;

import com.api.BaseApi;
import com.core.providers.PropertiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.ui.pages.ContactPage;

import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    static ContactPage contactPage;
    @BeforeSuite
    public static void setUp(){
        driver = createDriver();
        String url = PropertiesProvider.getProperty("url");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(url);
        if(!Thread.currentThread().getStackTrace()[1].getMethodName().contains("Login") ||
                !Thread.currentThread().getStackTrace()[1].getMethodName().contains("Registr")){
            LocalStorage local = ((WebStorage) driver).getLocalStorage();
            local.setItem("token",BaseApi.getTokenAuth());
            driver.navigate().refresh();
        }
        contactPage = new ContactPage(driver);
    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown(){
        driver.close();
    }
    public static WebDriver createDriver(){
        String browser = System.getProperty("browser", String.valueOf(Browser.CHROME));
        if (browser.equals(Browser.EDGE.browserName())) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equals(Browser.SAFARI.browserName())) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }

    public ContactPage getHelperContact() {
        return contactPage;
    }

}
