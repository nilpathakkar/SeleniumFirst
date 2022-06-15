package org.example;

import javafx.scene.control.Alert;
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
    NopCommerceNewRelease nopCommerceNewRelease = new NopCommerceNewRelease();
    FacebookPage facebookPage = new FacebookPage();
    ProductNikePage productNikePage = new ProductNikePage();


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


    //-------------------------------------------------------------------------------------------------------------------

    @Test
    public void getProductTitles(){
        homePage.getProductTitles();
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
    @Test
    public void verifyTheMessagePleaseSelectAnAnswer(){

        homePage.verifyTheMessagePleaseSelectAnAnswer();
    }
    @Test
    public void clickOnFacebookLogo(){

        homePage.clickOnFacebookLogo();
        facebookPage.verifyTheFacebookUrlAndHandlePopUpWindow();
    }

    @Test
    public void verifyTheProductSortByNameZtoA(){
        desktops.verifyTheProductSortByNameZtoA();
    }

    @Test
    public void verifyTheTitleNopCommerceNewRelease(){
        homePage.verifyTheTitleNopCommerceNewRelease();
        homePage.verifyTheUrlAfterClickingNopCommerceNewRelease();
        nopCommerceNewRelease.verifyTheMessageNopCommerceNewReleaseOnTopOfLeaveYourComment();
        nopCommerceNewRelease.enterDetailsOnTitleBox();
        nopCommerceNewRelease.enterDetailsOnCommentBox();
        nopCommerceNewRelease.clickOnNewComment();
        nopCommerceNewRelease.verifyYourCommentAddedOnCommentBox();
        nopCommerceNewRelease.listOfComments();
    }
    @Test
    public void enterTheProductNameInTheBox(){
        homePage.enterTheProductNameInTheBox();
        homePage.clickOnSearchButton();
        productNikePage.verifyTheUrl();
        productNikePage.allProductContainsNike();

    }
}
