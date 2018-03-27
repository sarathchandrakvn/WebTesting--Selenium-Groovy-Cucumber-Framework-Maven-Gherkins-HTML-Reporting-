package com.testAvenue.qa.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory



class HomePage extends BaseOfTodoPortal{

    WebDriver driver
    By signInText = By.xpath('/html/body/div[1]/div[2]')
    By myTasksLink = By.linkText('My Tasks')
    By homePageButton = By.xpath('/html/body/div[1]/div[1]/div/div[2]/ul[1]/li[1]/a')
    By logoutButton = By.xpath('/html/body/div[1]/div[1]/div/div[2]/ul[2]/li[2]/a')

     HomePage(WebDriver driver) {this.driver=driver
        PageFactory.initElements(driver,this)
    }


    boolean isSignInSuccessful()
    {
        waitUntilElementIsClickable(signInText,driver)
        pauseWebDriver(1,driver)
        getText(signInText,driver).trim().equalsIgnoreCase('Signed in successfully.')
    }

    boolean isMyTaskLinkPresent()
    {
        isElementPresent(myTasksLink,driver)
    }

    void clickMyTaskLinkPresent()
    {
        pauseWebDriver(1,driver)
        clickElement(myTasksLink,driver)
        pauseWebDriver(1,driver)
        waitForPagetoLoad(driver)
    }





    void logOut()
    {
        waitUntilElementIsClickable(homePageButton,driver)
        pauseWebDriver(1,driver)
        clickElement(homePageButton,driver)
        waitUntilElementIsClickable(logoutButton,driver)
        clickElement(logoutButton,driver)
        pauseWebDriver(1,driver)
        waitForPagetoLoad(driver)

     }


}
