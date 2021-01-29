@HRM
Feature: HRM System

  Background: Login into the HRM System
  	Given Go to Vacancy portal
  

  @Activity1
  Scenario: Creating a job vacancy
    Given Navigate to the Recruitment page
    Given Click on Vacancies Menu
    And Add Job Vacancy
    And Job Vacancy Form is filled and saved job title "QualityAnalyst", vacancy name "QualityAnalyst1", hiring manager "IBM 01"
    Then verify vacancy is created job title "QualityAnalyst", vacancy name "QualityAnalyst2", hiring manager "IBM 01"
    And Close the Browser
    
   @Activity2
  Scenario: Adding a candidate for recruitment
    And Navigate to Recruitment page
    And Click on Add to add candidate
    Then Fill the details of the candidate
    And Save 
    Then Confirm Candidate Entry
    And Close the Browser
    
    @Activity3
  Scenario Outline: Add multiple employees
    And Find PIM option in the menu and click it
    And Click the Add button to add a new Employee
    When fill required fields click Save "<firstName>", "<lastName>"
    Then Verify Employee created "<firstName>", "<lastName>"
    And Close the Browser

    Examples: 
      |firstName|lastName |
      |Ramya |Chilukuri|
      |Nithya|Kalakota|
      
      
       @Activity4
  Scenario Outline: Creating multiple vacancies
    And Navigate to Recruitment page
    Given Click on Vacancies Menu
    And Add Job Vacancy
    And Job Vacancy Form is filled and saved job title "<title>", vacancy name "<vacancy>", hiring manager "<hiringManager>"
    Then verify vacancy is created job title "<title>", vacancy name "<vacancy>", hiring manager "<hiringManager>"
    And Close the Browser

    Examples: 
      |title|vacancy|hiringManager|
      |Quality Analyst |QualityAnalyst1|IBM 01|
      |Quality Analyst |QualityAnalyst2|IBM 01|
    
    
  