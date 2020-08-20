package com.mycompany.l02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTestsPositive extends TestBase {


    @Test
    public void loginPositive() {
        //Printing Id of the thread on using which test method got executed
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.clear();
        userName.sendKeys("vishkov");

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys("CorrectPW");

        driver.findElement(By.id("logonButton")).click();

        assertFalse(isElementPresent(By.id("logonButton")));

    }

}
