Feature: As a ToDo App User
  I should be able to create a task
  So I can manage my tasks

  @login
  Scenario: As a Registered User I should be able to Signin
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    Then I am able to see MyTasks link on NavBar
    And Sign out Successfully


  @tasks
  Scenario: As a Registered User I should be able to Signin to view my tasks
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I am able to see one or more tasks on MyTasks Page
    And Sign out Successfully


  @negative
  Scenario: As a Registered User I should be able to Signin to view welcome message
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I see welcome message on MyTasks Page for a Username Sarath
    And Sign out Successfully


  @tasks
  Scenario: As a Registered User I should be able to create my owntask
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I should be able to create my ownTask
    And Sign out Successfully


  @negative
  Scenario: As a Registered User I should be able to Signin to create my ownTask with Atleast 3 characters
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I should be able to create my ownTask with Atleast 3 characters
    And Sign out Successfully


  @negative
  Scenario: As a Registered User I should be able to Signin but cannot create a task with more than 250 characters
    Given As a registered user when navigate to the landingPage
    And Sign in Successfully
    When I click MyTasks link on NavBar
    Then I cannot create a task with more than 250 characters
    And Sign out Successfully






