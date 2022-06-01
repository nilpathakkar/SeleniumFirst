package org.example;

import org.openqa.selenium.By;

public class Desktops extends Utils{
    private By _SelectBuildYourOwnComputer = By.xpath("//div[@class=\"product-item\"]/div[2]//a[@href=\"/build-your-own-computer\"]");



    public void userShouldSelectBuildYourOwnComputer(){
        //click on build your own computer
        clickOnElement(_SelectBuildYourOwnComputer);
    }
}
