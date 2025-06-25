Feature: User Management

Scenario: Verify if name of already created popular

Given: Application url is launched
And user is logged into the system
When User clicks on PIM Menu
And Click on add button
And Creates an user with valid details
When User clicks on Admin menu
And Click on add button on User management page 
When User selects roles as ESS
And Enters employee name
Then Populate list must contain newly created users  name
 