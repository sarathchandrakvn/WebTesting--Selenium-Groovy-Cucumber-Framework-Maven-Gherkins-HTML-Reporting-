Feature: As a ToDo App user
  I should be able to create a subtask
  So I can break down my tasks in smaller pieces


  @subtask1
  Scenario: As a Registered User I should be able to Signin and see buttons labeled Manage Subtasks
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I should see buttons labeled Manage Subtasks
    And Sign out Successfully

  @subtask1
  Scenario: As a Registered User I should be able to Signin and be able to add SubTasks and Verify
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    And create my ownTask
    Then I should be able to add SubTasks and Verify
    And Sign out Successfully


  @negative
  Scenario: As a Registered User I should be able to Signin and add SubTasks with description less than 250 characters
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    And create my ownTask
    Then I should be able to add SubTasks with description less than 250 characters
    And Sign out Successfully


  @negative
  Scenario: As a Registered User I should be able to Signin but cannot add SubTasks without description or due date
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    And create my ownTask
    Then I should not be able to add SubTasks without description or due date
    And Sign out Successfully



  @subtask
  Scenario: As a Registered User I should be able and new subtasks should be appended on bottom
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    And create my ownTask
    Then I should be able to add SubTasks and Verify that new subtasks are appended on bottom
    And Sign out Successfully

