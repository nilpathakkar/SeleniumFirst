package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCart extends Utils{
    private By _VerifyProductInShoppingCart = By.xpath("//td[@class=\"product\"]/a");



    public void userShouldVerifyProductInShoppingCart(){
        // To verify product in shopping basket
        String actualProductInBasket = driver.findElement(_VerifyProductInShoppingCart).getText();
        String expectedProductInBasket = "Build your own computer";
        Assert.assertEquals(actualProductInBasket, expectedProductInBasket, "Product is not match");
    }
}
