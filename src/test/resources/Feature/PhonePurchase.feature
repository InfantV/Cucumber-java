Feature: Login functionality
Background:
    Given user launches browser
  Scenario: phone purchase
    When user searches mobile
    Then user selects product
    
  #Scenario Outline: All Mobiles
   # When user searches mobile "<Phones>"
   # Then user selects product
  #Examples:
#|Phones|
#|Realme|
#|Samsung|
#|Redmi|

  #Scenario: Mobile purchase using list
   #When user searches mobile using one dim list
  # |Samsung|
  # |Redmi|
   #|Realme|
   #Then user selects product
   
   
 #Scenario: Mobile purchase using map
#    When user searches mobile using one dim map
   # |Phone1|Realme|
   # |Phone2|Redmi|
    #|Phone3|Samsung|
    #Then user selects product 
    
   # @screenshot
    Scenario: Take Screenshot
    When user take screenshot
@phone
      Scenario: phone purchase
    When user searches mobile
    And user selects the product
    Then user handling the window
    And user clicks the review 
    