package com.testAvenue.qa.domain.helpers

import com.testAvenue.qa.pages.HomePage
import com.testAvenue.qa.pages.LandingPage
import com.testAvenue.qa.pages.LoginPage
import com.testAvenue.qa.pages.MyTasksPage
import org.openqa.selenium.WebDriver

class TodoPortalHelper {

    static WebDriver driver
    static LandingPage landingPage
    static LoginPage loginPage
    static HomePage homePage
    static MyTasksPage myTasksPage

     TodoPortalHelper(WebDriver driver)
    {
        this.driver=driver
    }

    LandingPage getlandingPage()
    {
        return (landingPage == null ) ? landingPage = new LandingPage(driver) : landingPage
    }

    LoginPage getloginPage()
    {
        return (loginPage == null ) ? loginPage = new LoginPage(driver) : loginPage
    }

    HomePage gethomePage()
    {
        return (homePage == null ) ? homePage = new HomePage(driver) : homePage
    }

    MyTasksPage getmyTasksPage()
    {
        return (myTasksPage == null ) ? myTasksPage = new MyTasksPage(driver) : myTasksPage
    }

}


