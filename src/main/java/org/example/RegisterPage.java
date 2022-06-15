package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Utils{
    private By _EnterDetailsOnRegisterPageSuccessfully = By.xpath("//input[@id=\"gender-female\"]");
    private By _FirstName = By.xpath("//input[@name='FirstName']");
    private By _LastName = By.id("LastName");
    private By _SelectDayOfBirthFromDropDown = By.name("DateOfBirthDay");
    private By _SelectMonthOfBirthFromDropDown = By.name("DateOfBirthMonth");
    private By _SelectYearOfBirthFromDropDown = By.name("DateOfBirthYear");
    private By _EnterOnEmailAddress = By.xpath("//input[@name=\"Email\"]");
    private By _EnterOnPassword = By.xpath("//input[@name=\"Password\"]");
    private By _ConfirmPassword = By.xpath("//input[@name=\"ConfirmPassword\"]");
    private By _ClickOnRegister = By.xpath("//button[@name=\"register-button\"]");

    LoadProp loadprop = new LoadProp();


    public void userShouldEnterDetailsOnRegisterPageSuccessfully(){
        //select gender
        driver.findElement(_EnterDetailsOnRegisterPageSuccessfully).click();

        //enter first name
        // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation");
        typetext(_FirstName, loadprop.getProperty("firstname"));
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("LastNameTest");
        typetext(_LastName,loadprop.getProperty("lastname"));

        //Select day of birth from drop down
        Select DateOfBirthday = new Select(driver.findElement(_SelectDayOfBirthFromDropDown));
        int DateOfBirth = Integer.parseInt(loadprop.getProperty("DateOfBirthday"));
        DateOfBirthday.selectByIndex(DateOfBirth);

        //Select month of birth from drop down
        Select MonthOfBirthday = new Select(driver.findElement(_SelectMonthOfBirthFromDropDown));
        int MonthOfBirth = Integer.parseInt(loadprop.getProperty("MonthOfBirthday"));
        MonthOfBirthday.selectByIndex(MonthOfBirth);

        //Select year of birth from  drop down
        Select YearOfBirthday = new Select(driver.findElement(_SelectYearOfBirthFromDropDown));
        YearOfBirthday.selectByVisibleText(loadprop.getProperty("YearOfBirthday"));

        // Enter  on Email address
        //driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys("bmail@gmail.com");
        typetext(_EnterOnEmailAddress, loadprop.getProperty("EmailFirstPart")+ randomDate() +loadprop.getProperty("EmailSecondPart"));

        //Enter password
        // driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys("123456");
        typetext(_EnterOnPassword, loadprop.getProperty("EnterOnPassword"));

        //Enter confirm password
        // driver.findElement(By.xpath("//input[@name=\"ConfirmPassword\"]")).sendKeys("123456");
        typetext(_ConfirmPassword, loadprop.getProperty("ConfirmPassword"));

        //Click on register
        //driver.findElement(By.xpath("//button[@name=\"register-button\"]")).click();
        clickOnElement(_ClickOnRegister);

    }
}
