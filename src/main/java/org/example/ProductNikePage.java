package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductNikePage extends Utils {

    private By _allProductContainsNike = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");

    public void verifyTheUrl() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo.nopcommerce.com/search?q=Nike");
    }

    public void allProductContainsNike() {
        //check all product with nike name
        List<WebElement> productTitles = driver.findElements(_allProductContainsNike);
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains("Nike"));
        }
    }
}
