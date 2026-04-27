@tv 
Feature: Tv functionality
Background:
    Given user launches browser
  Scenario: Tv purchase
    When user searches tv
    Then user selects product
    
   #Scenario Outline: All Tvs
   # When user searches tv "<Tvs>"
   # Then user selects product
  #Examples:
#|Tvs|
#|LG|
#|Samsung|
#|Redmi|
@phone 
  Scenario: Tv purchase using list
   When user searches tv using one dim list
   |LG|
   |Redmi|
   |Realme|
   Then user selects product
   
 #Scenario: Tv purchase using map
    #When user searches tv using one dim map
    #|Tv1|LG|
    #|Tv2|Redmi|
    #|Tv3|Samsung|
    #Then user selects product 