@CRM
Feature: CRM Site
  
  Background: Login into the CRM Site
  	Given Navigate to Alchemy CRM site and login
  

  @Activity1
  Scenario: Counting Dashlets
    Then Print count of dashlets
    And Close the CRM Browser
    
  @Activity2
  Scenario: Create leads using parameterization
  	Then Navigate to Sales Leads and CreateLead
    Then Fill the details "Mrs. ", First Name "Ramya", Last Name "Chilukuri"
    Then Navigate to View Leads page to see results "Mrs. ", First Name "Ramya", Last Name "Chilukuri"
    And Close the CRM Browser
    
  @Activity3
  Scenario Outline: Schedule a meeting and invite members
    And Navigate to Activities Meetings ScheduleaMeeting
    And Enter the details of the meeting
    And Search for members and add them to the meeting    
    |fname|lname|email|
    |Anam|Mathew|phone27@trail.com|
    |Goldy|troff|sarah@trail.com|
    Then Navigate to View Meetings page and confirm creation of the meeting
    And Close the CRM Browser
    
  @Activity4
  Scenario Outline: Creating a Product
	  And Navigate to All Products CreateProduct
    And Enter Details of the Product "<productName>", "<productPrice>"
    And Click Save
    When Navigated to View Products Page
    Then All Products should be listed "<productName>"
    And Close the CRM Browser

    Examples: 
      | productName  | productPrice |
      |Television | 30000 |
      |Mobile| 10000|