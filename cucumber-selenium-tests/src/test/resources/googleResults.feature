Feature: Google Search Results
  	
Scenario: Verify google SEO
  	Given I navigate to google
  	When I google "IST Research"
  	Then IST Research is the first result
