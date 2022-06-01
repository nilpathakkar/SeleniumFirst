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


    public void userShouldEnterDetailsOnRegisterPageSuccessfully(){
        //select gender
        driver.findElement(_EnterDetailsOnRegisterPageSuccessfully).click();

        //enter first name
        // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation");
        typetext(_FirstName, "Automation");
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("LastNameTest");
        typetext(_LastName, "LastNameTest");

        //Select day of birth from drop down
        Select DateOfBirthday = new Select(driver.findElement(_SelectDayOfBirthFromDropDown));
        DateOfBirthday.selectByIndex(29);

        //Select month of birth from drop down
        Select MonthOfBirthday = new Select(driver.findElement(_SelectMonthOfBirthFromDropDown));
        MonthOfBirthday.selectByIndex(11);

        //Select year of birth from  drop down
        Select YearOfBirthday = new Select(driver.findElement(_SelectYearOfBirthFromDropDown));
        YearOfBirthday.selectByVisibleText("1984");

        // Enter  on Email address
        //driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys("bmail@gmail.com");
        typetext(_EnterOnEmailAddress, "bmail" + randomDate() + "@gmail.com");

        //Enter password
        // driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys("123456");
        typetext(_EnterOnPassword, "123456");

        //Enter confirm password
        // driver.findElement(By.xpath("//input[@name=\"ConfirmPassword\"]")).sendKeys("123456");
        typetext(_ConfirmPassword, "123456");

        //Click on register
        //driver.findElement(By.xpath("//button[@name=\"register-button\"]")).click();
        clickOnElement(_ClickOnRegister);

    }
}
