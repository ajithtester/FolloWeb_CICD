Feature: To verify the Dashboard

  @Regression 
  Scenario: To redirect to delivery request page from dashboard
    Given User clicks dashboard
    And User Clicks no of delivers
    Then User should be redirected to deliver request

  @Regression 
  Scenario: To redirect to company page from dashboard
    Given User clicks dashboard from deliver request page
    And User Clicks no of companies
    Then User should be redirected to companies

  @Regression 
  Scenario: To redirect to members page from dashboard
    Given User clicks dashboard from companies page
    And User Clicks no of members
    Then User should be redirected to members

  @Regression 
  Scenario: To redirect to equipment page from dashboard
    Given User clicks dashboard from members page
    And User Clicks no of equipment
    Then User should be redirected to equipment

  @Regression 
  Scenario: To Validate the no of deliveries
    Given User click Dashboard
    Then User validate the no of deliveries
    And User adds a request
    Then validate the no of deliveries

  @Regression 
  Scenario: To Validate the no of companies
    Given User click Dashboard
    And User validate the no of companies
    And User adds a company
    Then validate the no of companies
    And User deletes a company
    Then validate the no of companies

  @Regression 
  Scenario: To Validate the no of members
    Given User click Dashboard
    And User validate the no of members
    And User adds a members
    Then validate the no of members
    And User deletes a members
    Then validate the no of members

  @Regression 
  Scenario: To Validate the no of equipment
    Given User click Dashboard
    And User validate the no of equipment
    And User adds a equipment
    Then validate the no of equipment
    And User deletes a equipment
    Then validate the no of equipment

  @Regression 
  Scenario: To Validate the upcoming list
    Given User click Dashboard
    Given User validate the upcoming list
