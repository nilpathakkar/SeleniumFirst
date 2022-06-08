package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnComputer extends Utils{

    LoadProp loadProp =new LoadProp();

    private By _EmailAFriend = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    private By _IntelPentiumDualCoreE2200Processor = By.xpath("//select[@name=\"product_attribute_1\"]");
    private By _RAM2Gb = By.xpath("//select[@name=\"product_attribute_2\"]");
    private By _HDD320Gb = By.xpath("//input[@id=\"product_attribute_3_6\"]");
    private By _VistaPremiumOS = By.xpath("//input[@id=\"product_attribute_4_9\"]");
    private By _AcrobatSoftware = By.xpath("//label[@for=\"product_attribute_5_11\"]");
    private By _TotalCommander = By.xpath("//label[@for=\"product_attribute_5_12\"]");
    private By _AddToCartButton = By.xpath("//button[@id=\"add-to-cart-button-1\"]");
    private  By _ShoppingCart = By.xpath("//span[@class=\"cart-label\"]");




    public void userShouldEmailTheProductToAFriend(){
        //click on email a friend
        clickOnElement(_EmailAFriend);
    }

    public void userShouldSelectIntelPentiumDualCoreE2200(){
        //click on processor
        Select Processor= new Select(driver.findElement(_IntelPentiumDualCoreE2200Processor));
        Processor.selectByValue(loadProp.getProperty("1"));
    }

    public void userShouldSelect2GB(){
        //click RAM 2 GB
        Select RAM= new Select(driver.findElement(_RAM2Gb));
        RAM.selectByValue(loadProp.getProperty("3"));
    }

    public void userShouldSelectHDD(){
        //click on HDD (option 1)
        clickOnElement(_HDD320Gb);
    }

    public void userShouldSelectOS(){
        //click on OS (option 2)
        clickOnElement(_VistaPremiumOS);
    }

    public void userShouldSelectAcrobatReader(){
        //click on Software (option 2)
        clickOnElement(_AcrobatSoftware);
    }

    public void userShouldSelectTotalCommander(){
        //click on Software (option 3)
        clickOnElement(_TotalCommander);
    }

    public void userShouldClickOnAddToCartButton(){
        //click on ADD TO CART button
        clickOnElement( _AddToCartButton);
    }
    public void userShouldClickOnShoppingCart(){
        //click on SHOPPING CART
        clickOnElement(_ShoppingCart);
    }

}
