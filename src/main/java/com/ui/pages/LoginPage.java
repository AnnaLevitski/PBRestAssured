package com.ui.pages;

import com.core.models.dto.AuthRequestDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage(){
        driver.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
        return this;
    }
    public ContactPage logIn(AuthRequestDTO authRequestDTO){
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(authRequestDTO.getUsername());
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(authRequestDTO.getPassword());
        driver.findElement(By.xpath("//button[@name='login']")).click();
        return new ContactPage(driver);
    }







}
