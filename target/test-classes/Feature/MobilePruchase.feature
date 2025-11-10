#Author: your.infant@your.domain.com
Feature: Mobile purchase feature

Background:
 		Given User launch the browser
    And Login into the Flipkart page
    
 
 @mobile
  Scenario: Mobile purchase scenario
    When User search the mobile
    And User select the product
    And User handling the window
    Then User validating the product

  #Scenario: Mobile purchase scenario with one dimensional List
    #When User search the mobile by using one dimensional List
      #| realme  |
      #| Samsung |
    #And User select the product
    #And User handling the window
    #Then User validating the product


  #Scenario: Mobile purchase scenario with one dimensional map
    #Given User launch the browser
    #And Login into the Flipkart page
    #When User search the mobile by using one dimensional map
      #| Phone1 | realme  |
      #| Phone2 | Samsung |
    #And User select the product
    #And User handling the window
    #Then User validating the product
    #
   #Scenario: Mobile purchase scenario with outline
    #Given User launch the browser
    #And Login into the Flipkart page
    #When User search the mobile "<Phones>"
    #And User select the product
    #And User handling the window
    #Then User validating the product 
    #
    #Examples:
    #|Phones|
    #|realme|
    #|iPhone|
