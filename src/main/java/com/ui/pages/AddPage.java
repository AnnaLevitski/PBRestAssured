package com.ui.pages;

import com.core.models.dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddPage {
    WebDriver driver;

    public AddPage(WebDriver driver) {
        this.driver = driver;
    }
    public ContactPage addContact(ContactDTO contactDTO){
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(contactDTO.getName());
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(contactDTO.getLastName());
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(contactDTO.getPhone());
        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys(contactDTO.getEmail());
        driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(contactDTO.getAddress());
        driver.findElement(By.xpath("//input[@placeholder='description']")).sendKeys(contactDTO.getDescription());
        driver.findElement(By.xpath("//button/b[text()='Save']")).click();
        return new ContactPage(driver);
    }
}
