@phone
Feature: Login functionality

  Scenario: phone purchase
    Given user launches browser
    When user searches mobile
    Then user selects product
    
  #Scenario Outline: All Mobiles
   # Given user launches browser
   # When user searches mobile "<Phones>"
   # Then user selects product
  #Examples:
#|Phones|
#|Realme|
#|Samsung|
#|Redmi|

  Scenario: Mobile purchase using list
   Given user launches browser
   When user searches mobile using one dim list
   |Samsung|
   |Redmi|
   |Realme|
   Then user selects product
   
 #Scenario: Mobile purchase using map
#    When user searches mobile using one dim map
   # |Phone1|Realme|
   # |Phone2|Redmi|
    #|Phone3|Samsung|
    #Then user selects product 
    
    
    