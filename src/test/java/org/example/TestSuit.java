package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegisterSuccess registerSuccess = new RegisterSuccess();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    EmailAFriend emailAFriend= new EmailAFriend();
    Computers computers = new Computers();
    Desktops desktops =new Desktops();
    ShoppingCart shoppingCart =new ShoppingCart();


    @Test
    public void UserShouldBeRegisterSuccessfully(){
        homePage.clickOnRegisterButton();
        registerPage.userShouldEnterDetailsOnRegisterPageSuccessfully();
        registerSuccess.verifyThatUserRegisteredSuccessfully();
    }

    //-------------------------------------------------------------------------------------------------------------------
    @Test
    public void usherShouldSelectTheProductAndEmailToTheFriendSuccessfully(){
        homePage.clickOnRegisterButton();
        registerPage.userShouldEnterDetailsOnRegisterPageSuccessfully();
        registerSuccess.verifyThatUserRegisteredSuccessfully();
        registerSuccess.userShouldClickTheContinueButton();
        homePage.userShouldSelectTheBuildYourOwnComputerProduct();
        buildYourOwnComputer.userShouldEmailTheProductToAFriend();
        emailAFriend.userShouldEnterFriendsEmail();
        emailAFriend.userShouldClickOnSendEmail();
        emailAFriend.verifyMessageHasBeenSentForProduct();

    }

    //-------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldAbleToChangeAndVerifyTheCurrencySuccessfully(){
        homePage.userShouldSelectEuroCurrencyFromDropDownMenu();
        homePage.VerifyTheProductPriceInEuroCurrency();
        homePage.userShouldSelectTheUSDollarCurrencyFromDropDownMenu();
        homePage.verifyTheProductPriceInUsDollarCurrency();

    }


    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeSelectFeatureSuccessFully() {
        homePage.userShouldSelectComputersOption();
        computers.userShouldSelectDesktopsOption();
        desktops.userShouldSelectBuildYourOwnComputer();
        buildYourOwnComputer.userShouldSelectIntelPentiumDualCoreE2200();
        buildYourOwnComputer.userShouldSelect2GB();
        buildYourOwnComputer.userShouldSelectHDD();
        buildYourOwnComputer.userShouldSelectOS();
        buildYourOwnComputer.userShouldSelectAcrobatReader();
        buildYourOwnComputer.userShouldSelectTotalCommander();
        buildYourOwnComputer.userShouldClickOnAddToCartButton();
        buildYourOwnComputer.userShouldClickOnShoppingCart();
        shoppingCart.userShouldVerifyProductInShoppingCart();
    }
    @Test
    public void onlyRegisteredUsersCanVote(){
        homePage.SelectGoodOptionInCommunityPoll();
        homePage.ClickOnVoteButton();
        homePage.verifyTheMessageThatOnlyRegisteredUsersCanVote();
        homePage.clickOnRegisterButton();
        registerPage.userShouldEnterDetailsOnRegisterPageSuccessfully();
        registerSuccess.verifyThatUserRegisteredSuccessfully();
        registerSuccess.userShouldClickTheContinueButton();
        homePage.SelectGoodOptionInCommunityPoll();
        homePage.ClickOnVoteButton();

    }
}
