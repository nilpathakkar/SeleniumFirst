package org.example;

import org.openqa.selenium.By;

public class Computers extends Utils{

    private By _SelectDesktopOption = By.xpath("//h2/a[@title=\"Show products in category Desktops\"]");


    public void userShouldSelectDesktopsOption(){
        //click on Desktop
        clickOnElement( _SelectDesktopOption);
    }
}
