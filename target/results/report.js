$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/subTasks.feature");
formatter.feature({
  "line": 1,
  "name": "As a ToDo App user",
  "description": "I should be able to create a subtask\nSo I can break down my tasks in smaller pieces",
  "id": "as-a-todo-app-user",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2404680281,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "As a Registered User I should be able and new subtasks should be appended on bottom",
  "description": "",
  "id": "as-a-todo-app-user;as-a-registered-user-i-should-be-able-and-new-subtasks-should-be-appended-on-bottom",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 45,
      "name": "@subtask"
    }
  ]
});
formatter.step({
  "line": 47,
  "name": "As a registered user when navigate to the landingPage",
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "Sign in Successfully",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I click MyTasks link on NavBar",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "create my ownTask",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "I should be able to add SubTasks and Verify that new subtasks are appended on bottom",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "Sign out Successfully",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "landingPage",
      "offset": 42
    }
  ],
  "location": "ToDoPortalSteps.groovy:25"
});
formatter.result({
  "duration": 4399063453,
  "status": "passed"
});
formatter.match({
  "location": "ToDoPortalSteps.groovy:35"
});
formatter.result({
  "duration": 1500051150,
  "status": "passed"
});
formatter.match({
  "location": "ToDoPortalSteps.groovy:49"
});
formatter.result({
  "duration": 706850040,
  "status": "passed"
});
formatter.match({
  "location": "ToDoPortalSteps.groovy:105"
});
formatter.result({
  "duration": 760055587,
  "status": "passed"
});
formatter.match({
  "location": "ToDoPortalSteps.groovy:121"
});
formatter.result({
  "duration": 1601389005,
  "error_message": "Assertion failed: \n\nassert getText(By.xpath(\u0027/html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a\u0027),driver).trim().contains(one)\n       |          |                                                                          |       |      |        |\n       Subtasktwo By.xpath: /html/body/div[4]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a|       |      false    SubtaskOne\n                                                                                             |       Subtasktwo\n                                                                                             ChromeDriver: chrome on MAC (8be3b5e33172fe131eb045dbdb4c5741)\n\n\tat com.testAvenue.qa.pages.MyTasksPage.createSubtaksAndVerifyThatTasksAreAppendedBottom(MyTasksPage.groovy:175)\n\tat com.testAvenue.qa.pages.MyTasksPage$createSubtaksAndVerifyThatTasksAreAppendedBottom$0.call(Unknown Source)\n\tat com.testAvenue.qa.steps.ToDoPortalSteps$_run_closure16.doCall(ToDoPortalSteps.groovy:123)\n\tat ✽.Then I should be able to add SubTasks and Verify that new subtasks are appended on bottom(features/subTasks.feature:51)\n",
  "status": "failed"
});
formatter.match({
  "location": "ToDoPortalSteps.groovy:55"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 139260,
  "status": "passed"
});
});