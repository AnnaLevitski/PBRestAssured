package com.ui.pages;

import com.core.models.dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ContactPage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactPage removeContact(){
        driver.findElement(By.xpath("//a[normalize-space()='CONTACTS']")).click();
        int countContactsBefore = countContacts()-1;
        driver.findElement(By.xpath("//div[1][@class='contact-item_card__2SOIM']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("contact-item-detailed_card__50dTS")));
        int countContactsAfter = countContacts();
        Assert.assertEquals(countContactsBefore, countContactsAfter);
        return this;
    }

    public ContactPage assertContactPage(){
        WebElement buttonHome = driver.findElement(By.xpath("//a[normalize-space()='HOME']"));
        Assert.assertTrue(buttonHome.isDisplayed());
        return this;
    }

    public AddPage navigateToAddPage(){
        driver.findElement(By.xpath("//a[normalize-space()='ADD']")).click();
        return new AddPage(driver);
    }
    public int countContacts(){
        List<WebElement> contactsList = driver.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        return contactsList.size();
    }

    public ContactPage assertLastContact(ContactDTO contactDTO){
        WebElement lastContactName = driver.findElement(By.xpath("//h2[text()='"+contactDTO.getName()+"']"));
        WebElement lastContactPhone = driver.findElement(By.xpath("//h3[text()='"+contactDTO.getPhone()+"']"));

        Assert.assertTrue(lastContactName.isDisplayed());
        Assert.assertTrue(lastContactPhone.isDisplayed());
        return this;
    }


}
