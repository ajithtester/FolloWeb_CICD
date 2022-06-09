Feature: To verify the DFOW feature

  @DFOW @Regression 
  Scenario: To navigate to DFOW feature
    Given User clicks settings button
    And User scrolls in the settings menu
    And User clicks the DFOW from the menu
    Then DFOW page should be displayed

  @DFOW @Regression
  Scenario: Add DFOW list
    Given User clicks add row
    And User adds DFOW list
    And User clicks the save button
    Then DFOW list should get added

  @DFOW @Regression
  Scenario: Search DFOW
    Given User enters the dfow value in the search bar

  @DFOW @Regression
  Scenario: Export DFOW list
    Given User looks for the export button
    Then User clicks the export button to export the file

  @DFOW @Regression
  Scenario: Edit a DFOW from the list
    Given User edits a DFOW from the list
    And User clicks the save button
    Then User should get edit success popup

  @DFOW @Regression
  Scenario: Delete a DFOW from the list
    Given User deletes a DFOW from the list

  @Dfow
  Scenario: Delete all DFOW from the list
    Given User selects all DFOW
    And User clicks remove button and click yes
    Then All the DFOW in the list should be removed

  @DFOW @Regression
  Scenario: Import DFOW list
    Given User clicks import button
    And User selects file to upload
    And User clicks the done button
    Then DFOW list from the excel should get added
