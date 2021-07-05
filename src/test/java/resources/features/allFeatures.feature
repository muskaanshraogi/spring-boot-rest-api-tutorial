Feature: Users should be able to submit and get data

Scenario: Create a user
When User sends their data username "testuser" firstname "Test" lastname "User" email "usertest@gmail.com" password "test@123" admin "Admin"
Then User profile should be created

Scenario: Display all users
When User requests data
Then All users are displayed