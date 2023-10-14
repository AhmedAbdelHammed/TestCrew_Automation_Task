@STCWeb
Feature: Subscription Types

  Background:
    Given I am on subscription page with title "Choose Your Plan"

  Scenario Outline: Check subscription titles and types
    Given I click on change country button
    When I switch to specific "<country>"
    Then I should see "<plan title>" with "<price>" and "<currency>" and "<recurrency>"
    Examples:
      | country | plan title | price | currency | recurrency |
      | sa      | LITE       | 15    | SAR      | month      |
      | sa      | CLASSIC    | 25    | SAR      | month      |
      | sa      | PREMIUM    | 60    | SAR      | month      |
      | bh      | LITE       | 2     | BHD      | month      |
      | bh      | CLASSIC    | 3     | BHD      | month      |
      | bh      | PREMIUM    | 6     | BHD      | month      |
      | kw      | LITE       | 1.2   | KWD      | month      |
      | kw      | CLASSIC    | 2.5   | KWD      | month      |
      | kw      | PREMIUM    | 4.8   | KWD      | month      |
