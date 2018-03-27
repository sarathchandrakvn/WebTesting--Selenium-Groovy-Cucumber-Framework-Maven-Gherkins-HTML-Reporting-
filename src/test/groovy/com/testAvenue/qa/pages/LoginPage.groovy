package com.testAvenue.qa.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import java.util.concurrent.TimeUnit


class LoginPage extends BaseOfTodoPortal{

    WebDriver driver
    private final By emailId = By.id('user_email')
    private final By passwordField = By.id('user_password')
    private final By signInButton = By.xpath('//*[@id="new_user"]/input')



    LoginPage(WebDriver driver) {this.driver=driver
        PageFactory.initElements(driver,this)
    }

    void enterEmailId(String id)
    {
        waitUntilElementIsClickable(emailId,driver)
        pauseWebDriver(1,driver)
         sendText(emailId,id,driver)
        pauseWebDriver(1,driver)

    }

    void enterPassword(String password)
    {
        waitUntilElementIsClickable(passwordField,driver)
        pauseWebDriver(1,driver)
        sendText(passwordField,password,driver)
        pauseWebDriver(1,driver)

    }

    void clickSignInButton()
    {
        waitUntilElementIsClickable(signInButton,driver)
        pauseWebDriver(1,driver)
         clickElement(signInButton,driver)
        pauseWebDriver(1,driver)
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)

    }

}
