package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NopCommerceNewRelease extends Utils {

    private By _verifyTheMessageNopCommerceNewReleaseOnTopOfLeaveYourComment = By.xpath("//div[@class=\"page news-item-page\"]/div/h1");
    private By _enterDetailsOnTitleBox = By.xpath("//input[@class=\"enter-comment-title\"]");
    private By _enterDetailsOnCommentBox = By.name("add-comment");
    private By _verifyYourCommentAddedOnCommentBox = By.xpath("//div[@class='comments']//p[.='product recommended']");
    private By _listOfComments = By.xpath("//div[@class='comment-title']");


    public void verifyTheMessageNopCommerceNewReleaseOnTopOfLeaveYourComment(){
        String ActualMessage = driver.findElement(_verifyTheMessageNopCommerceNewReleaseOnTopOfLeaveYourComment).getText();
        Assert.assertEquals(ActualMessage,"nopCommerce new release!","message not match");
    }

    public void enterDetailsOnTitleBox(){
        typetext(_enterDetailsOnTitleBox,"John Smith");
    }

    public void enterDetailsOnCommentBox(){
        typetext(By.className("enter-comment-text"),"product recommended");
    }

    public void clickOnNewComment(){
        clickOnElement(_enterDetailsOnCommentBox);
    }

    public void verifyYourCommentAddedOnCommentBox(){
        String ActualComment = driver.findElement(_verifyYourCommentAddedOnCommentBox).getText();
        String ExpectedComment = "product recommended";
        Assert.assertEquals(ActualComment,ExpectedComment,"message not match");
    }

    public void listOfComments(){
        String titles="John Smith";
        List<WebElement> comments=driver.findElements(_listOfComments);
        List<String>listOfComments = new ArrayList<>();
        for (WebElement e:comments){
            listOfComments.add(e.getText());
        }

        Assert.assertTrue(listOfComments.contains(titles));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment,titles,"comments not in order");
    }



}
