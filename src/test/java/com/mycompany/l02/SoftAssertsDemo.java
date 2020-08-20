package com.mycompany.l02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;

public class SoftAssertsDemo extends TestBase {


    String loginData = "vishkov";
    String passwordData = "CorrectPW";

    @Test
    public void basicCommandsTest() {
        SoftAssert softAssert = new SoftAssert();


        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("logonButton"));
        WebElement titleHeader = driver.findElement(By.cssSelector("h3"));

        softAssert.assertFalse(userName.isDisplayed());
        softAssert.assertFalse(password.isDisplayed());
        softAssert.assertTrue(titleHeader.isDisplayed());


        softAssert.assertAll();

        loginButton.click();

        assertFalse(isElementPresent(By.id("logonButton")));

    }


    public void typeText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);

    }

}
