package com.testAvenue.qa.steps.support

import com.testAvenue.qa.domain.helpers.LoadDriver
 import cucumber.api.groovy.Hooks
 import groovy.util.logging.Slf4j
import org.openqa.selenium.WebDriver

this.metaClass.mixin(Hooks)

WebDriver driver

@Slf4j
class ToDoPortalWorld
{
    ToDoPortalWorld()
    {
        log.info('Setting up')
    }


}

World{
    new ToDoPortalWorld()
}

Before() {
    new LoadDriver().loadChromeDriver()
 }

After() {
  //  new LoadDriver().unloadDriver()
}