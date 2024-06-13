package com.ui;

import com.api.BaseApi;
import com.core.models.enums.ScreenSize;
import com.core.providers.PropertiesProvider;
import com.core.providers.ScreenProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
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
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.core.providers.DriverProvider.createDriver;


public class TestBase {
    public static WebDriver driver;
    static ContactPage contactPage;

    private static final String SCREEN = System.getProperty("screen", "DESKTOP_S");

    @BeforeSuite
    @Parameters("browser")
    public static void setUp(String browser){
        driver = createDriver(browser);

        try {
            ScreenSize screenSize = ScreenProvider.getScreenSize(SCREEN);
            driver.manage().window().setSize(new Dimension(screenSize.getWidth(), screenSize.getHeight()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        String url = PropertiesProvider.getProperty("url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
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

    public ContactPage getHelperContact() {
        return contactPage;
    }

}
