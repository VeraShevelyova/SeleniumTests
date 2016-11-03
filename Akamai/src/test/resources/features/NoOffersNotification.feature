Feature: Customer is notified when no offers match given criteria

  Scenario Outline: Search for a job matching given criteria
    Given Customer is on 'http://akamaijobs.referrals.selectminds.com/'
    When Customer specifies job title <job>
    And clicks on 'Search'
    Then Notification about no offers found is displayed for <job>
    Examples:
    |job |
    |XXX |