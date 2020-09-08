package com.mycompany.l02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class BasicCommandsTest extends TestBase {


    String loginData = "vishkov";
    String passwordData = "CorrectPW";

    @Test(enabled = false)
    public void basicCommandsTest() {
        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("logonButton"));
        WebElement titleHeader = driver.findElement(By.cssSelector("h3"));


        userName.clear();
        userName.sendKeys(loginData);

        password.clear();
        password.sendKeys(passwordData);

        typeText(userName, loginData);
        typeText(password,passwordData);


        System.out.println("titleHeader text is  " + titleHeader.getText());
        System.out.println("username data-val attribute is   " + userName.getAttribute("data-val"));
        System.out.println("username class is  " + userName.getCssValue("background-color"));

        loginButton.click();

        assertFalse(isElementPresent(By.id("logonButton")));

    }


    public void typeText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);

    }

}
