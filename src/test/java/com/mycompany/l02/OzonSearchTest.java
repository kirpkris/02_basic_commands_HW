package com.mycompany.l02;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OzonSearchTest extends TestBase {

    @Test
    public void searchItemWithAssert() {
        //Printing Id of the thread on using which test method got executed
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());

        String expectedItemPrice = "692";
        String expectedItemColor = "rgba(249, 17, 85, 1)";
        String expectedItemBrand = "Faber-Castell";

        WebElement searchField = driver.findElement(By.cssSelector("[name = 'search']"));
        searchField.sendKeys("142886201");
        searchField.sendKeys(Keys.ENTER);

        WebElement searchedItemPrice = driver.findElement(By.cssSelector("[href $= '142886201/'] > div > span"));
        assertTrue(searchedItemPrice.getText().contains(expectedItemPrice));
        assertEquals(searchedItemPrice.getCssValue("color"), expectedItemColor);

        WebElement searchedItemBrand = driver.findElement(By.cssSelector(".b0s5 > a"));
        assertEquals(searchedItemBrand.getText(), expectedItemBrand);
    }

    @Test
    public void searchItemWithSoftAssert() {
        //Printing Id of the thread on using which test method got executed
        System.out.println("Test Case Two with Thread Id:- "
                + Thread.currentThread().getId());
        String expectedItemPrice = "692";
        String expectedItemColor = "rgba(249, 17, 85, 1)";
        String expectedItemBrand = "Faber-Castell";

        WebElement searchField = driver.findElement(By.cssSelector("[name = 'search']"));
        searchField.sendKeys("142886201");
        searchField.sendKeys(Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        WebElement searchedItemPrice = driver.findElement(By.cssSelector("[href $= '142886201/'] > div > span"));
        softAssert.assertTrue(searchedItemPrice.getText().contains(expectedItemPrice));
        softAssert.assertEquals(searchedItemPrice.getCssValue("color"), expectedItemColor);

        WebElement searchedItemBrand = driver.findElement(By.cssSelector(".b0s5 > a"));
        softAssert.assertEquals(searchedItemBrand.getText(), expectedItemBrand);

        softAssert.assertAll();
    }

}
