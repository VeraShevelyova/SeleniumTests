Feature: Logged out customer is able to search for a job

  Scenario Outline: Search for a job matching given criteria
    Given Customer is on 'http://akamaijobs.referrals.selectminds.com/'
    When Customer specifies job title <job>
    And Location <location>
    And clicks on 'Search'
    Then Any job offers are found
    Examples:
    | job | location |
    | Test | Krakow, Poland |