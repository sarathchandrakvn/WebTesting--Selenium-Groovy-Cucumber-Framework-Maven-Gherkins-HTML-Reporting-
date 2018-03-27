package com.testAvenue.qa.domain.helpers
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.chrome.ChromeDriver



class LoadDriver {
   static WebDriver driver


    static WebDriver loadChromeDriver() {
        if(driver==null){
         System.setProperty('webdriver.chrome.driver', '/Users/imsarath/Downloads/chromedriver')
         driver = new ChromeDriver()
         }
        else
            return driver
    }

    static WebDriver getDriver()
    {
        return driver
    }

    static void unloadDriver()
    {
          // driver.quit()
    }

}
