package com.testAvenue.qa.pages

import com.gargoylesoftware.htmlunit.ElementNotFoundException
import groovy.util.logging.Slf4j
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.*
import org.openqa.selenium.Keys
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.util.concurrent.TimeUnit

@Slf4j
class BaseOfTodoPortal{

     long globalTimeOutinSeconds = 10
    private WebDriver driver



    void scrollHorizontalLeft(By locator, int index,WebDriver driver) {
        Actions clickAction = new Actions(driver)
        WebElement scrollablePane = driver.findElement(locator)
        clickAction.moveToElement(scrollablePane).click().build().perform()
        Actions scrollAction = new Actions(driver)
        index.times {
            scrollAction.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_LEFT).perform()
        }
    }
    void submitInformation(By locator,WebDriver driver) {
        driver.findElement(locator).submit()
    }

    void clearInformation(By locator,WebDriver driver) {
        driver.findElement(locator).clear()
    }

    String getText(By locator,WebDriver driver) {
        try {
            return driver.findElement(locator).getText()
        } catch (Exception e) {
              return 'Unable to get text'
        }
    }

    void scrollIntoViewJs(By locator,WebDriver driver) {
        log.info("Scrolling [(" + locator.toString() + ")] into view.")
        WebElement element = driver.findElement(locator)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element)
        pauseWebDriver(2)
    }




    void deleteAllCookies(WebDriver driver){
        driver.manage().deleteAllCookies()
    }

    void refreshPage(WebDriver driver){
        driver.navigate().refresh()
        log.info("Page Refreshed!\n")
    }

    void pauseWebDriver(long seconds,WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS)
    }

    void clickButton(By locator,WebDriver driver)
    {
        try {
            waitUntilElementIsClickable(locator)
            driver.findElement(locator).click()
        }
        catch(Exception e)
        {
            log.error(e.printStackTrace())
        }
    }


    void clickElement(By locator,WebDriver driver)
    {
        try {
            waitUntilElementIsClickable(locator,driver)
            driver.findElement(locator).click()
        }
        catch(Exception e)
        {
            log.error(e.printStackTrace())
        }
    }


    void sendText(By locator,String text,WebDriver driver)
    {
        try {
            waitUntilElementIsClickable(locator,driver)
            driver.findElement(locator).sendKeys(text)
        }
        catch(Exception e)
        {
            log.error(e.printStackTrace())
        }
    }

    WebElement waitUntilElementIsClickable(By locator,WebDriver driver)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10)
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator))
            return element
            }
        catch(ElementNotFoundException e)
        {
            log.info(e.printStackTrace())
            return null
        }
     }

    boolean isElementPresent(By locator,WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,10)
        wait.until(ExpectedConditions.elementToBeClickable(locator))
        return driver.findElement(locator)

    }

    void waitForPagetoLoad(WebDriver driver)
    {
        driver.manage().timeouts().pageLoadTimeout(globalTimeOutinSeconds,TimeUnit.SECONDS)
    }

    void quitDriver()
    {
        driver.quit()
    }
}
