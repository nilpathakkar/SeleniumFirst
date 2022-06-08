package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterSuccess extends Utils{
    private By _UserRegisteredSuccessfully = By.className("result");
    private By _ClickTheContinueButton = By.xpath("//a[@class=\"button-1 register-continue-button\"]");




    public void verifyThatUserRegisteredSuccessfully(){
        String actualMessage = driver.findElement(_UserRegisteredSuccessfully).getText();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not success ");
    }

    public void userShouldClickTheContinueButton(){
        // click on continue button
        clickOnElement(_ClickTheContinueButton);
    }}
