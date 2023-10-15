@OrangeHrmAPI
Feature: Orange HRM candidate scenarios

  Background:
    Given I navigate to OrangeHRM login page
    When I login with admin user name and password
    Then I should get the session cookie

  Scenario Outline: Successful candidate creation using OrangeHRM API
    Given I create candidate using API with "<first name>" and "<last name>" and "<email>" with "<consent>" and receive <status code>
    Then I should receive creation response with the same "<first name>" and "<last name>" and "<email>"

    Examples:
      | first name | last name  | email          | consent | status code |
      | Ahmed      | Abdelhamid | test@test.com  | false   | 200         |
      | Mohamed    | Ahmed      | test2@test.com | false   | 200         |


  Scenario: Search candidate using application status
    Given I search candidates using API with shortlisted status "2" and limit "10" and receive 200 status code
    Then I should receive search response with all the applicants having "shortlisted" application status "2"

  Scenario: Delete candidate using id created above
    Given I create candidate using API with "delete" and "candidate" and "delete@delete.com" with "true" and receive 200
    Given I delete candidate created above using API with the candidate id and receive 200 status code
    Then I should receive successful delete response with the same candidate id