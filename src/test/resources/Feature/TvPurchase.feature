@tv
Feature: Tv functionality

  Scenario: Tv purchase
    Given user launches browser
    When user searches tv
    Then user selects product
    
   #Scenario Outline: All Tvs
   # Given user launches browser
   # When user searches tv "<Tvs>"
   # Then user selects product
  #Examples:
#|Tvs|
#|LG|
#|Samsung|
#|Redmi|

  Scenario: Tv purchase using list
   Given user launches browser
   When user searches tv using one dim list
   |LG|
   |Redmi|
   |Realme|
   Then user selects product
   
 #Scenario: Tv purchase using map
    #Given user launches browser
    #When user searches tv using one dim map
    #|Tv1|LG|
    #|Tv2|Redmi|
    #|Tv3|Samsung|
    #Then user selects product 