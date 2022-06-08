package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static java.awt.SystemColor.text;

public class HomePage extends Utils{

    LoadProp loadProp = new LoadProp();

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
    private By _getProductTitles = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _clickOnFacebookLogo = By.xpath("//li[@class='facebook']");
    private By _verifyTheTitleNopCommerceNewRelease = By.xpath("//div[@class=\"news-items\"]//div[2]//a[@class=\"news-title\"]");
    private By _enterTheProductNameInTheBox = By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]");
    private By _clickOnSearchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");






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
        Euro.selectByVisibleText(loadProp.getProperty("CurrencyOptionOne"));
    }

    public void VerifyTheProductPriceInEuroCurrency(){
        String actualCurrency = driver.findElement(_TheProductPriceInEuroCurrency).getText();
        String expectedCurrency = "€1032.00";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency is different.");
    }

    public void userShouldSelectTheUSDollarCurrencyFromDropDownMenu() {
        //US Dollar currency from drop down menu
        Select USDollar = new Select(driver.findElement(_SelectTheUSDollarCurrencyFromDropDownMenu));
        USDollar.selectByVisibleText(loadProp.getProperty("CurrencyOptionTwo"));
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

    public void getProductTitles(){
        driver.get("https://demo.nopcommerce.com/");
        List<WebElement> productTitles = driver.findElements(_getProductTitles);
        System.out.println(productTitles.size());
        for (WebElement e:productTitles){
            System.out.println(e.getText());
        }
    }

    public void verifyTheMessagePleaseSelectAnAnswer(){
       // click on vote button
        clickOnElement(_ClickOnVoteButton);

        //switching to alert
        Alert alert = driver.switchTo().alert();

        //Capturing alert message
        String alertMessage= driver.switchTo().alert().getText();

        //to verify massage
        Assert.assertEquals(alertMessage,"Please select an answer","Message not verify");

        // Accepting alert
        alert.accept();

    }

    public void clickOnFacebookLogo() {
        //CLICK ON FACEBOOK LOGO
        clickOnElement(_clickOnFacebookLogo);
    }

    public void verifyTheTitleNopCommerceNewRelease(){
        //Verify The NopCommerce New Release And Click on it
        String ActualResult = driver.findElement(_verifyTheTitleNopCommerceNewRelease).getText();
        String ExpectedResult = "nopCommerce new release!";
        Assert.assertEquals(ActualResult,ExpectedResult,"nopCommerce new release!");
        clickOnElement(_verifyTheTitleNopCommerceNewRelease);
    }

    public void verifyTheUrlAfterClickingNopCommerceNewRelease(){
        //Verify The Nopcommerce New Release URL
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://demo.nopcommerce.com/nopcommerce-new-release","url not match");
    }

    public void enterTheProductNameInTheBox(){
        //enter nike in search box
        typetext(_enterTheProductNameInTheBox,"Nike");
    }

    public void clickOnSearchButton(){
        //click on search button
        clickOnElement(_clickOnSearchButton);
    }


    }








