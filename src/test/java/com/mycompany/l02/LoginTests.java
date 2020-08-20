package com.mycompany.l02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void loginNegative() {
        //Printing Id of the thread on using which test method got executed
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.clear();
        userName.sendKeys("TEST");

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys("TEST");

        driver.findElement(By.id("logonButton")).click();

        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-error']"))
                .getText().contains("Ошибка"));

    }

}
