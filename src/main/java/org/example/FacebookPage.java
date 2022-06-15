package org.example;

import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class FacebookPage extends Utils{

    public void verifyTheFacebookUrlAndHandlePopUpWindow(){
        //created object of main window handles
        String MainWindow = driver.getWindowHandle();
        //to handle all new window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                String url = driver.getCurrentUrl();
                Assert.assertEquals(url, "https://www.facebook.com/nopCommerce", "url not match to current url");

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window
        driver.switchTo().window(MainWindow);
    }
}
