@tag
Feature: Negative testing
 
 Background:
    Given Go to URL 
    
@Errorcheck
Scenario Outline: Login error validation
Given user enters <username> and <password> 
Then error message "Incorrect email or password." should be displayed
Examples:
| username | password |
| wrong@gmail.com | wrong123 |