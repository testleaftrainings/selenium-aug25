@Accounts
Feature: This feature is used to create and manage the accounts for the user

@Create
Scenario: Create the account

Given Login into the Leaftaps application using username as "demosalesmanager" and password as "crmsfa"
When Click on the CRMSFA
And Click on the accounts tab
And Click on the create account link
Given Enter the account name 
When Click on the create account button
Then Validate the account name is same