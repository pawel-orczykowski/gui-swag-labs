Feature: Swag Lab Shop Purchase

  As a shop Customer
  I want to use shops features
  So that I can buy shop items

  Background:
    Given shop main page

  Scenario Outline: "<login>" user can login to shop
    When user enters "<login>" as login
    And user enters "<password>" as password
    And user clicks on submit button
    Then user is logged in to shop

    Examples:
    | login                    | password     |
    | standard_user            | secret_sauce |
    | problem_user             | secret_sauce |
    | performance_glitch_user  | secret_sauce |

  Scenario: "locked_out_user" user can't login to shop
    When user enters "locked_out_user" as login
    And user enters "secret_sauce" as password
    And user clicks on submit button
    Then user is not logged in to shop

  Scenario: Standard user can add items to cart
    When user enters "standard_user" as login
    And user enters "secret_sauce" as password
    And user clicks on submit button
    When user adds random product to cart from Product page
    And user clicks on cart icon from top menu
    Then picked product is present in cart

  Scenario: Standard user buys product
    When user enters "standard_user" as login
    And user enters "secret_sauce" as password
    And user clicks on submit button
    And user is logged in to shop
    And user adds random product to cart from Product page
    And user clicks on cart icon from top menu
    And user clicks on checkout button in Your Cart page
    And user enters "John" as First Name in Checkout: Your information page
    And user enters "Doe" as Last Name in Checkout: Your information page
    And user enters "90210" as Zip Code in Checkout: Your information page
    And user clicks on continue button in Checkout: Your information page
    When user clicks on finish button in Checkout: Overview page
    Then user is seeing Finish page
    And Thank You massage "THANK YOU FOR YOUR ORDER" is displayed
    And Order next steps message: "Your order has been dispatched, and will arrive just as fast as the pony can get there!" is displayed
    And Pony Express graphic is displayed



