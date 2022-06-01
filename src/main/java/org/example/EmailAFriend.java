package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriend extends Utils{
    private By _EnterFriendsEmail = By.xpath("//input[@class=\"friend-email\"]");
    private By _ClickOnSendEmail = By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]");
    private By _MessageHasBeenSentForProduct = By.xpath("//div[@class=\"result\"]");


    public void userShouldEnterFriendsEmail(){
        //type an email address
        typetext(_EnterFriendsEmail,"abc" + randomDate() + "@gmail.com");
    }

    public void userShouldClickOnSendEmail(){
        //click on send email
        clickOnElement(_ClickOnSendEmail);
    }

    public void verifyMessageHasBeenSentForProduct(){
        // to verify message (assert)
        String actualResult = driver.findElement(_MessageHasBeenSentForProduct).getText();
        String expectedResult = "Your message has been sent.";
        Assert.assertEquals(actualResult, expectedResult, "Message has not been sent ");
    }

}
