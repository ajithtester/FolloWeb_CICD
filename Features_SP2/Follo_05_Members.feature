Feature: To verify the Members feature

  @Members @Regression @filter
  Scenario: To click members button from the menu
    Given User clicks members button

  @Members @Regression
  Scenario: To send invites to Members
    Given User enters invite members button
    And User enters members mailid
    And User assign company and role to the member
    And User clicks send invite button
    Then User should see the invite sent success message

  @Members @Regression
  Scenario: Edit a member from the list
    Given User edit a member from the list

  @Members @Regression
  Scenario: Search Members
    Given User search and view the members

  @Members @Regression
  Scenario: To send re-invites to members in pending state
    Given User send reinvites to the pending members

  @Members @Regression @filter
  Scenario: Filter Members based on role
    Given User search and filter the company based on role

  @Members @Regression
  Scenario: Delete a member from the list
    Given User deletes a member from the list

  @Members
  Scenario: Delete all member except origin member from the list
    Given User selects all members
    And User clicks remove button and click yes from the popup
    Then All the members except origin member should be deleted
