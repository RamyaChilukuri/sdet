@Jobs_project
Feature: Jobs Board

@Activity_jobs_1
Scenario: Create a new user
	Given User Login Page
	When User enters details "root" and "pa$$w0rd"
	Then Click the menu item
	And  Locate the Add New button and fill neccesary details
	And Verify that the user was created
	And Close the jobs browser
	
@Activity_jobs_2	
Scenario: Searching for jobs
		Given User is on Jobs page
    When User searches for job and change job type
    Then Find job and apply for job
    And Close the Browser
		

	
@Activity_jobs_3	
Scenario: Posting a job
		Given User is on Jobs page
    When User goes to post a job
    Then Post a job with details "ramya@trail.com" "Quality Analyst" and "Hyderabad"
    And Verify job is posted
    And Close the Browser

 @Activity_jobs_4
Scenario Outline: Using Examples table to post a job
	  Given User is on Jobs page
    When User goes to post a job
    Then Post a job with details "<Email>" "<Title>" and "<Location>"
    And Verify job is posted
    And Close the Browser
    
Examples:
    | Email 				  | Title 				   |Location |
    | ramya@trail.com | Quality Analyst  | Hyderabas|