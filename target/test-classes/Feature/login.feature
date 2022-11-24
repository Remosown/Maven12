@white
Feature: To validate the login functionality of facebook Application

Background:
Given User have to launch the browser and url
@like
Scenario: To login by using valid username and valid password
    When User have to enter the valid email amd valid password
    And User have to click the login button
    Then User have to clase the browser
@close    
    Scenario Outline: To login Facebook by valid username and invalid password
    
          When User have to enter the valid "<username>" and invalid "<password>"
          And User have to click the login button
          Then User have to close the browser
          
          
          Examples:
                |email|password|
                |maven|tat456|
                |selenium|poy789|
                |market|toy675|
    
    