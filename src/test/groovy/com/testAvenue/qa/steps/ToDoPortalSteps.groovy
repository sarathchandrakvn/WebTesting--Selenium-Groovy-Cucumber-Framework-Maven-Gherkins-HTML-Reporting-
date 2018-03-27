package com.testAvenue.qa.steps

import com.testAvenue.qa.domain.helpers.LoadDriver
import com.testAvenue.qa.pages.HomePage
import com.testAvenue.qa.pages.LandingPage
import com.testAvenue.qa.pages.LoginPage
import com.testAvenue.qa.pages.MyTasksPage
import org.openqa.selenium.WebDriver

import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.*

import com.testAvenue.qa.domain.helpers.TodoPortalHelper
import org.openqa.selenium.chrome.ChromeDriver

WebDriver driver
TodoPortalHelper todoPortalHelper
LandingPage landingPage
LoginPage loginPage
HomePage homePage
MyTasksPage myTasksPage



Given(~/^As a registered user when navigate to the (.+)/) {String url->

        todoPortalHelper = new TodoPortalHelper(LoadDriver.getDriver())
        landingPage = todoPortalHelper.getlandingPage()
        if(url.equalsIgnoreCase('landingPage')) {
            landingPage.navigateToLandingPage(loadAttributesFromFile('baseUrl'))
            landingPage.clickSignInButton()
        }
}

And(~/^Sign in Successfully$/) { ->
    loginPage=todoPortalHelper.getloginPage()
    loginPage.enterEmailId(loadAttributesFromFile('username'))
    loginPage.enterPassword(loadAttributesFromFile('password'))
    loginPage.clickSignInButton()
    homePage = todoPortalHelper.gethomePage()
    assert homePage.isSignInSuccessful() : 'SignIn Failed'
}

Then(~/^I am able to see MyTasks link on NavBar$/) { ->
    assert homePage.isMyTaskLinkPresent() : 'Cannot find MyTaskLink'
}


When(~/^I click MyTasks link on NavBar$/) { ->
      homePage.clickMyTaskLinkPresent()
}



And(~/^Sign out Successfully$/) { ->
      homePage.logOut()
    }


Then(~/^I am able to see one or more tasks on MyTasks Page$/) {->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.isAtleastOneTasksShownOnPage()
}


Then(~/^I see welcome message on MyTasks Page for a Username (.+)$/) {String firstname->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.checkForWelcomeMessage(firstname) : 'Error in Welcome Message'
}

Then(~/^I should be able to create my ownTask$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createNewTaskandVerify()

}

Then(~/^I should be able to create my ownTask with Atleast 3 characters$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createNewTaskWithlessThan3CharactersAndVerify()
}


Then(~/^I cannot create a task with more than 250 characters$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createNewTaskWithMoreThan251CharactersAndVerify()
}




Then(~/^I should see buttons labeled Manage Subtasks$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.subTasksButtonVisibleVerify()
}



Then(~/^I should be able to add SubTasks and Verify$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createSubtaksAndVerify()
}



And(~/^create my ownTask$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createNewTaskandVerify()
}

Then(~/^I should be able to add SubTasks with description less than 250 characters$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createSubtakswithLessThan250CharactersDesc() : 'Subtask dec is more than 250 characters'
}

Then(~/^I should not be able to add SubTasks without description or due date$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createSubtaskWithoutDescOrDueDate() : 'SubTask created with blank desc and duedate'
}


Then(~/^I should be able to add SubTasks and Verify that new subtasks are appended on bottom$/) { ->
    myTasksPage = todoPortalHelper.getmyTasksPage()
    assert myTasksPage.createSubtaksAndVerifyThatTasksAreAppendedBottom()
}




static String loadAttributesFromFile(String getAttribute) {
    Properties properties = new Properties()
    File propertiesFile = new File("${System.getProperty("user.dir")}/src/test/groovy/com/testAvenue/qa/domain/entity/testData.properties")
    propertiesFile.withInputStream {
        properties.load it
    }
    if(getAttribute.equalsIgnoreCase('baseUrl'))
        return properties.baseUrl
    else if(getAttribute.equalsIgnoreCase('username'))
        return   properties.username
    else if(getAttribute.equalsIgnoreCase('password'))
        return   properties.password
    else
        return null
}
