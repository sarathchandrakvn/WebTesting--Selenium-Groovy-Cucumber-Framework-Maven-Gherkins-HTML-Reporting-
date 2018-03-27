package com.testAvenue.qa.pages

import com.gargoylesoftware.htmlunit.ElementNotFoundException
 import org.apache.xpath.operations.Bool
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.JavascriptExecutor

class MyTasksPage extends BaseOfTodoPortal{

    WebDriver driver
    JavascriptExecutor jse
    WebElement element


    String alphabet = (('A'..'N')+('P'..'Z')+('a'..'k')+('m'..'z')+('2'..'9')).join()
    def n = 251

    By welcomeMessage = By.xpath('/html/body/div[1]/h1')
    By taskTextBar = By.id('new_task')
    By addTaskButton = By.xpath('/html/body/div[1]/div[2]/div[1]/form/div[2]/span')
    By newlyAddedTask = By.xpath('/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/a')
    By createSubTaskButton = By.xpath('/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button')
    By subTaskTextBox = By.id('new_sub_task')
    By subTaskDatePick = By.id('dueDate')
    By subTaskAddButton = By.id('add-subtask')
    By subtaskCloseButton = By.xpath('/html/body/div[4]/div/div/div[3]/button')

    MyTasksPage(WebDriver driver) {this.driver=driver
        PageFactory.initElements(driver,this)
    }

    boolean isAtleastOneTasksShownOnPage()
    {

        boolean tasksPresent = Boolean.FALSE
        for(int index=1;index<5;index++)
        {
            try {
                waitUntilElementIsClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[${index}]/td[2]/a"), driver)
                element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[${index}]/td[2]/a"))
                jse = (JavascriptExecutor)driver
                jse.executeScript("arguments[0].style.border='2px solid blue'",element)
                if(isElementPresent(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[${index}]/td[2]/a"), driver))
                {
                    tasksPresent = Boolean.TRUE
                    jse.executeScript("arguments[0].style.border='2px solid green'",element)
                }
                }
            catch(ElementNotFoundException e)
            {

            }
        }
        tasksPresent
    }

    boolean checkForWelcomeMessage(String firstName)
    {
        waitUntilElementIsClickable(welcomeMessage,driver)
        pauseWebDriver(1,driver)
        assert getText(welcomeMessage,driver).trim().equalsIgnoreCase("‘Hey ${firstName}, this is your todo list for today")

    }

    boolean createNewTaskandVerify()
    {
        Date currentDate = new Date()
        String text = (currentDate.getTime()).toString()
        waitUntilElementIsClickable(taskTextBar,driver)
        clickElement(taskTextBar,driver)
        pauseWebDriver(1,driver)
        sendText(taskTextBar,text,driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(addTaskButton,driver)
        pauseWebDriver(1,driver)
        clickElement(addTaskButton,driver)
        pauseWebDriver(1,driver)
        pauseWebDriver(4,driver)
        waitUntilElementIsClickable(newlyAddedTask,driver)
        pauseWebDriver(1,driver)
        getText(newlyAddedTask,driver).trim().equalsIgnoreCase(text)
    }

    boolean createNewTaskWithlessThan3CharactersAndVerify()
    {
        Date currentDate = new Date()
        String text = (currentDate.getTime()).toString()
        waitUntilElementIsClickable(taskTextBar,driver)
        clickElement(taskTextBar,driver)
        pauseWebDriver(1,driver)
        sendText(taskTextBar,'ab',driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(addTaskButton,driver)
        pauseWebDriver(1,driver)
        clickElement(addTaskButton,driver)
        pauseWebDriver(1,driver)
        pauseWebDriver(4,driver)
        waitUntilElementIsClickable(newlyAddedTask,driver)
        pauseWebDriver(1,driver)
        getText(newlyAddedTask,driver).trim().size() > 3
    }



    boolean createNewTaskWithMoreThan251CharactersAndVerify()
    {
        Date currentDate = new Date()
        String text = (currentDate.getTime()).toString()
        waitUntilElementIsClickable(taskTextBar,driver)
        clickElement(taskTextBar,driver)
        pauseWebDriver(1,driver)
        sendText(taskTextBar,giveMeKey().toString(),driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(addTaskButton,driver)
        pauseWebDriver(1,driver)
        clickElement(addTaskButton,driver)
        pauseWebDriver(1,driver)
        pauseWebDriver(4,driver)
        waitUntilElementIsClickable(newlyAddedTask,driver)
        pauseWebDriver(1,driver)
        getText(newlyAddedTask,driver).trim().size() < 251
    }



    boolean subTasksButtonVisibleVerify()
    {
        boolean found = Boolean.FALSE
        for(int index=1;index<6;index++)
        {
            try
            {
                waitUntilElementIsClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[${index}]/td[4]/button"),driver)
                pauseWebDriver(1,driver)
                assert getText(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[${index}]/td[4]/button"),driver).trim().contains('Manage Subtasks')
                found = Boolean.TRUE
            }
            catch(ElementNotFoundException e)
            {

            }
        }
        found
     }

    boolean createSubtaksAndVerify()
    {
        addSubTask('SubtaskOne','1/3/2018')
        pauseWebDriver(1,driver)
        addSubTask('Subtasktwo','1/3/2018')
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(subtaskCloseButton,driver)
        clickElement(subtaskCloseButton,driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(createSubTaskButton,driver)
        getText(createSubTaskButton,driver).trim().contains('2')

    }



    boolean createSubtaksAndVerifyThatTasksAreAppendedBottom()
    {
        String one = 'SubtaskOne'
        String two = 'Subtasktwo'
        addSubTask(one,'1/3/2018')
        pauseWebDriver(1,driver)
        addSubTask(two,'1/3/2018')
        pauseWebDriver(1,driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'),driver)
       assert getText(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'),driver).trim().contains(one)

    }

    boolean createSubtakswithLessThan250CharactersDesc()
    {
        addSubTask(giveMeKey().toString(),'1/3/2018')
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'),driver)
        pauseWebDriver(1,driver)
        assert getText(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'),driver).size() <250


    }


    boolean createSubtaskWithoutDescOrDueDate()
    {
        boolean result = Boolean.TRUE
        addSubTask('','')
        pauseWebDriver(1,driver)
        try {
            waitUntilElementIsClickable(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'), driver)
            pauseWebDriver(1, driver)
            assert getText(By.xpath('/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a'), driver).size() >0
            result = Boolean.FALSE
        }
        catch(ElementNotFoundException e)
        {

        }
        result
    }



    void addSubTask(String taskName,String date)
    {
        waitUntilElementIsClickable(createSubTaskButton,driver)
        pauseWebDriver(1,driver)
        clickElement(createSubTaskButton,driver)
        waitUntilElementIsClickable(subTaskTextBox,driver)
        clickElement(subTaskTextBox,driver)
        pauseWebDriver(1,driver)
        sendText(subTaskTextBox,taskName,driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(subTaskDatePick,driver)
        pauseWebDriver(1,driver)
        sendText(subTaskDatePick,date,driver)
        pauseWebDriver(1,driver)
        waitUntilElementIsClickable(subTaskAddButton,driver)
        pauseWebDriver(1,driver)
        clickElement(subTaskAddButton,driver)
    }

    def giveMeKey(){
        def key
        for(def i=0;i<50;i++){
            key = new Random().with {
                (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
            }
        }
        return key
    }

}
