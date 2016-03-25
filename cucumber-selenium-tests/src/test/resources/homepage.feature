Feature: IST Home page
  	
  	Scenario Outline: Verify navigation menu items
    Given I navigate to the IST website
    Then I should see the "<value>" menu item
    
    Examples:
    | value |
    | HOME |
    | VISION |
    | PULSE |
    | CAPABILITIES |
    | OUR WORK |
    | BLOG |
    | ABOUT |
    | EMPLOYMENT |
  	
