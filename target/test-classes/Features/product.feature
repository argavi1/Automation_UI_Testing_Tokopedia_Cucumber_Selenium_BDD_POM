Feature: Search for laptop ASUS on Tokopedia
  Scenario: User can search for laptop ASUS and click on product details
    Given I am on Tokopedia website home page
    And I search Laptop Asus on searching bar
    And I directed into List of Laptop Asus page
    When I click detail product
    Then I directed into product's detail page
