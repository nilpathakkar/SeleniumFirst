package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utils {

    LoadProp loadProp = new LoadProp();


    private By _SelectBuildYourOwnComputer = By.xpath("//div[@class=\"product-item\"]/div[2]//a[@href=\"/build-your-own-computer\"]");
    private By _productTitlesBeforeFilter = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _productTitlesAfterFilter = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _sortByNameZtoA = By.id("\"products-orderby\"");
    private By _verifyTheProductSortByNameZtoA = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");


    public void userShouldSelectBuildYourOwnComputer() {
        //click on build your own computer
        clickOnElement(_SelectBuildYourOwnComputer);
    }

    public void productTitlesBeforeFilter() {

        //list of productTitles Before Filter
        List<WebElement> productTitlesBeforeFilter = driver.findElements(_productTitlesBeforeFilter);
        for (WebElement e : productTitlesBeforeFilter) {
            System.out.println(e.getText());
        }
    }

    public void productTitlesAfterFilter() {

        //list of products after filter
        List<WebElement> productTitlesAfterFilter = driver.findElements(_productTitlesAfterFilter);
        for (WebElement s : productTitlesAfterFilter) {
            System.out.println(s.getText());
        }
    }

    public void sortByNameZtoA() {

        //Select Sort By Name:ZtoA
        Select NameZtoA = new Select(driver.findElement(_sortByNameZtoA));
        NameZtoA.selectByValue(loadProp.getProperty("SortByNameZtoA"));
    }

    public void verifyTheProductSortByNameZtoA() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> productTitlesBeforeFilter = driver.findElements(_verifyTheProductSortByNameZtoA);
        for(WebElement e:productTitlesBeforeFilter ){
            obtainedList.add(e.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String s:obtainedList){
            sortedList.add(s);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
    }

}