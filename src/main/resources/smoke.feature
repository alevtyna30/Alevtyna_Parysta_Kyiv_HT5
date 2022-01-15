Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: check the filter
    Given User opens '<homePage>' page
    And user clicks catalog button
    And user clicks category of product
    And user clicks on subcategory
    And user applies filter
    Then user checks that current page contains '<brandName>'

    Examples:
      | homePage                | brandName |
      | https://www.amazon.com/ | HP        |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User clicks 'toys and games' button
    And User choose the product
    And User clicks 'Add to Cart' button on product
    And User clicks 'close' popup
    Then User checks that amount in cart is '<amountInCart>'

    Examples:
      | homePage                | amountInCart |
      | https://www.amazon.com/ | 1            |

  Scenario Outline: Enter wrong number in sign in page
    Given User opens '<homePage>' page
    And User clicks 'Sign in' button
    And User enter wrong phone number
    And User clicks 'Continue' button
    Then User checks that '<error message>' is appear on the page

    Examples:
      | homePage                | error message                                    |
      | https://www.amazon.com/ | We cannot find an account with that mobile number|

  Scenario Outline: Enter more characters then allow
    Given User opens '<homePage>' page
    And User clicks 'Gift cards' button
    And User clicks 'Birthday' occasion
    And User clicks 'EGift' button
    And User choose 'EGift' card type
    When User enter sentences in 'Message' field
    Then User checks that '<warning message>' is appear

    Examples:
      | homePage                | warning message                        |
      | https://www.amazon.com/ | Message must be 500 characters or fewer|

  Scenario Outline: Check that search result contains search word
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    Then User checks that page contains search keyword '<keyword>'

    Examples:
      | homePage                | keyword|
      | https://www.amazon.com/ | Bicycle|

  Scenario Outline: Check that url contains search word
    Given User opens '<homePage>' page
    And User clicks 'Change language'
    And User clicks 'Select The currency'
    And User select the currency in dropdown
    When User clicks 'Save changes' button
    Then User checks that current url contains '<currency>'

    Examples:
      | homePage                | currency         |
      | https://www.amazon.com/ | currency=AED     |


  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks Carousel Row visibility
    And User checks 'Cart' Button visibility
    And User checks 'Global Location' Button visibility
    And User checks 'SignIn' Page visibility
    And User checks catalog Button visibility
    And User checks 'CustomerService' button visibility
    And User checks logo visibility
    Then User checks search field visibility

    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check click on the logo from any page home page should open
    Given User opens '<homePage>' page
    And User clicks catalog Button
    And User clicks electronic section
    And User clicks camera and photo section
    When User clicks main logo of the website
    Then User checks that home page is open with '<current url>'

    Examples:
      | homePage                |current url                        |
      | https://www.amazon.com/ |https://www.amazon.com/ref=nav_logo|






