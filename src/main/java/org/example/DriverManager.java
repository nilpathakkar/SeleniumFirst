package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{

    String browserName= "edge";
    public void openTheBrowser() {
        //Open Chrome
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            //Open Firefox
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
            else if (browserName.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }
    public void Quit() {

        driver.quit();
    }
}
