package com.testAvenue.qa.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import java.util.concurrent.TimeUnit


class LandingPage extends BaseOfTodoPortal{

WebDriver driver
    private final By signInButton = By.xpath('/html/body/div[1]/div[1]/div/div[2]/ul[2]/li[1]/a')


    LandingPage(WebDriver driver)
{
    this.driver = driver
    PageFactory.initElements(driver,this)
}


 void navigateToLandingPage(String baseUrl)
 {
       pauseWebDriver(2,driver)
        driver.get(baseUrl)
      waitForPagetoLoad(driver)
  }


    void clickSignInButton()
    {
        waitUntilElementIsClickable(signInButton,driver)
        pauseWebDriver(1,driver)
        clickElement(signInButton,driver)
        pauseWebDriver(1,driver)
    }
}
