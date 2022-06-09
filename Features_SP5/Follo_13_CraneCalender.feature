Feature: To verify the Crane calendar

  @CraneCalendar @Regression 
  Scenario: To click Crane calendar button from the menu
    Given User clicks Crane calendar button from the menu
    Then Crane calendar page should display

  @CraneCalendar @Regression 
  Scenario: To add new crane request
    Given User add new crane request

  @CraneCalendar @Regression 
  Scenario: Search crane request
    Given User search and view the crane request in calendar settings

  @CraneCalendar @Regression 
  Scenario: Edit a Crane request from the list
    Given User edit a Crane request from the list

  @CraneCalendar @Regression 
  Scenario: Filter a Crane request from the list
    Given User filter the Crane request from the list

  @CraneCalendar @Regression 
  Scenario: User view Crane request information
    Given User view Crane request information

  @CraneCalendar @Regression 
  Scenario: User add a comment to a crane request
    Given User add a comment to a crane request in calendar settings

  @CraneCalendar @Regression 
  Scenario: User add attachment to the Crane calendar request
    Given User add attachment to the crane calendar request

  @CraneCalendar @Regression 
  Scenario: User complete the crane request
    Given User complete the crane requestt in calendar settings

  @CraneCalendar @Regression 
  Scenario: User view and approve or reject the crane request
    Given User approve or reject the crane request in calendar settings

  @CraneCalendar @Regression 
  Scenario: Push a crane request in calendar settings to void
    Given User a crane request in calendar settings to void
