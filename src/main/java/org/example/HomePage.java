package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends Utils{
    private By _ClickOnRegisterButton = By.className("ico-register");
    private  By _SelectTheBuildYourOwnComputer = By.xpath("//div[@class=\"product-item\"]/div[2]//a[@href=\"/build-your-own-computer\"]");
    private  By _SelectComputerOption = By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]");
    private By _SelectEuroCurrencyFromDropDownMenu = By.name("customerCurrency");
    private By _TheProductPriceInEuroCurrency = By.xpath("//div[@data-productid=\"1\"]/div[2]//div[3]/div/span");
    private By _SelectTheUSDollarCurrencyFromDropDownMenu = By.name("customerCurrency");
    private By _TheProductPriceInUsDollarCurrency = By.xpath("//div[@data-productid=\"1\"]/div[2]//div[3]/div/span");
    private By _SelectGoodOptionInCommunityPoll = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _ClickOnVoteButton = By.xpath("//button[@id=\"vote-poll-1\"]");
    private By _TheMessageThatOnlyRegisteredUsersCanVote = By.xpath("//div[@style=\"display: none;\"]");
    private By _TheNumberOfVotesMessage = By.className("poll-total-votes");



    public void clickOnRegisterButton(){
        // click on register button
        clickOnElement(_ClickOnRegisterButton);
    }

    public void userShouldSelectTheBuildYourOwnComputerProduct(){
        //click on build your own computer
        clickOnElement(_SelectTheBuildYourOwnComputer);
    }

    public void userShouldSelectComputersOption(){
        //click on Computers
        clickOnElement(_SelectComputerOption);
    }
    public void userShouldSelectEuroCurrencyFromDropDownMenu() {
        //Euro currency from drop down menu
        Select Euro = new Select(driver.findElement(_SelectEuroCurrencyFromDropDownMenu));
        Euro.selectByVisibleText("Euro");
    }

    public void VerifyTheProductPriceInEuroCurrency(){
        String actualCurrency = driver.findElement(_TheProductPriceInEuroCurrency).getText();
        String expectedCurrency = "€1032.00";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency is different.");
    }

    public void userShouldSelectTheUSDollarCurrencyFromDropDownMenu() {
        //US Dollar currency from drop down menu
        Select USDollar = new Select(driver.findElement(_SelectTheUSDollarCurrencyFromDropDownMenu));
        USDollar.selectByVisibleText("US Dollar");
    }

    public void verifyTheProductPriceInUsDollarCurrency(){
        String actualcurrency = driver.findElement(_TheProductPriceInUsDollarCurrency).getText();
        String expectedcurrency = "$1,200.00";
        Assert.assertEquals(actualcurrency, expectedcurrency, "Currency is different.");
    }

    public void SelectGoodOptionInCommunityPoll(){
        //select Good option in community poll
        clickOnElement(_SelectGoodOptionInCommunityPoll);
    }

    public void ClickOnVoteButton(){
        //click on vote button
        clickOnElement(_ClickOnVoteButton);
    }

    public void verifyTheMessageThatOnlyRegisteredUsersCanVote(){
        //Verify The Message That Only registered users can vote
        String ActualVoteMessage=driver.findElement(_TheMessageThatOnlyRegisteredUsersCanVote).getText();
        String ExpectedVoteMessage = "Only registered users can vote";
        Assert.assertNotEquals(ActualVoteMessage,ExpectedVoteMessage, "User is registered");
    }
    public void verifyTheNumberOfVotesMessage(){
        //verification//Assert
        String messagevoteactual=driver.findElement(_TheNumberOfVotesMessage).getText();
        String messagevoteexpected = " vote";
        Assert.assertTrue(messagevoteactual.contains( "vote" ));
    }

}
