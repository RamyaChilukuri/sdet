package StepDefinitions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMActivity extends BaseClass {

	String empId="";
	@Given("^Go to Vacancy portal$")
	public void wpadminPage() throws InterruptedException {
				createWebDriver();
				driver.get("http://alchemy.hguy.co/orangehrm");
		//driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Given("^Navigate to the Recruitment page$")
	public void navigate_to_recruitement_page() throws InterruptedException {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
	}
	
	@Given("^Click on Vacancies Menu$")
	public void navigate_to_vacancies_menu() throws InterruptedException {
		driver.findElement(By.linkText("Vacancies")).click();
	}
		
	@Given("^Add Job Vacancy$")
	public void add_job_vacancy() throws InterruptedException {
	

		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		
	}
	
	@Given("^Navigate to Recruitment page$")
	public void navigate_to_the_recruitement_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
	}
	
	@Given("^Click on Add to add candidate$")
	public void add_candidate() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("btnAdd")).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addCandidateHeading")));
	}
	
	
	@Given("^Find PIM option in the menu and click it$")
	public void pim_option_in_the_menu_click() {
		WebElement PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();
		PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));

		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Employee Information");
		System.out.println("Employee Information Page is displayed");
	}
	
	@Given("^Click the Add button to add a new Employee$")
	public void click_on_add_employee() {
		driver.findElement(By.id("btnAdd")).click();
		System.out.println("Add Button is clicked");

	}
	

	@When("^fill required fields click Save \"(.*)\", \"(.*)\"$")
	public void fill_required_fields(String firstName,String lastName) {
	
		// Fill in the required fields and click Save.
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		System.out.println("Employee Details are entered");

		empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee Id : " + empId);
		//make sure to create login details to check
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(firstName+lastName);

		driver.findElement(By.id("btnSave")).click();
		System.out.println("Save Button is clicked");

	}

	@Then("Verify Employee created {string}, {string}")
	public void verify_employee_is_created(String firstName,String lastName) {
		// Navigate back to the Admin page and verify the creation of your employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));
		System.out.println("Navigated to Admin Page");

		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(empId);

		driver.findElement(By.id("searchBtn")).click();
		System.out.println("The new employee created is searched");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).getText(), empId);
		System.out.println("Employee id is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(), firstName);
		System.out.println("First Name is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(), lastName);
		System.out.println("Last Name is displayed correctly");
		
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}


	@Then("^Fill the details of the candidate$")
	public void fill_the_details_of_candidate() {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Mounika");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Yerragundla");
        
        driver.findElement(By.id("addCandidate_email")).sendKeys("Yerragundla_mounika@test.com");
	}

	@Then("^Save$")
	public void save() {
	    //Click button to upload
	    driver.findElement(By.id("btnSave")).click();

	}
	@Then("^Confirm Candidate Entry$")
	public void confirm_candidate_entry() {
		
			
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("candidateSearch_candidateName")));
		
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Mounika Yerragundla");
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Candidate
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[3]/a")).getText(),"Mounika Yerragundla");

	}

	
	@When("^Job Vacancy Form is filled and saved job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void job_vacancy_form_is_filled_and_saved(String jobTitleL,String vacancyName,String hiringManager) {
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
		
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringManager);
		
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("^verify vacancy is created job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void vacancy_should_be_created(String jobTitleL,String vacancyName,String hiringManagerL) {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		
		Select jobTitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		Select jobVacancy = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
		jobVacancy.selectByVisibleText(vacancyName);
		
		Select hiringManager = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		hiringManager.selectByVisibleText(hiringManagerL);
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Vacancy
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText(),vacancyName);
		//Verify Job Title
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(),jobTitleL);
		//Verify Hiring Manager
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(),hiringManagerL);
		
		
	}

}
