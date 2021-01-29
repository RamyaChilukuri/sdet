package StepDefinitions;

import java.util.List;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMActivity extends BaseClass {
	
	@Given("^Navigate to Alchemy CRM site and login$")
	public void Login_to_site() {
		createWebDriver();
		driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'dashlet_entire')]")));
        
	}

	@Given("^Navigate to Activities Meetings ScheduleaMeeting$")
	public void navigate_to_activities_meetings_schedulea_meeting() {
		WebElement menuActivities = driver.findElement(By.id("grouptab_3"));
		menuActivities.click();
		
		WebElement menuMeeting = driver.findElement(By.xpath("//a[@id='moduleTab_9_Meetings' and text()='Meetings']"));
		
		System.out.println(menuMeeting.getText());
		menuMeeting.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
	}
	
	@Given("^Enter the details of the meeting$")
	public void enter_the_details_of_the_meeting() {
		
		driver.findElement(By.id("name")).sendKeys("Meeting scheduled for activty3");

	}
	
	@Given("^Search for members and add them to the meeting$")
	public void search_for_members_and_add_them_to_the_meeting(DataTable searchData) throws InterruptedException {
	
		List<List<String>> search = searchData.asLists();
		
		System.out.println("number of rows " +search.size());
		for(int i=1;i<search.size();i++) {
			driver.findElement(By.id("search_first_name")).sendKeys(search.get(i).get(0));
			driver.findElement(By.id("search_last_name")).sendKeys(search.get(i).get(1));
			driver.findElement(By.id("search_email")).sendKeys(search.get(i).get(2));
			
			driver.findElement(By.id("invitees_search")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("invitees_add_1")).click();
			
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_last_name")).clear();
			driver.findElement(By.id("search_email")).clear();
		}
			
		driver.findElement(By.id("SAVE_HEADER")).click();
		
	}
	
	@Given("^Navigate to All Products CreateProduct$")
	public void navigate_to_all_products_create_product() {
		WebElement menuActivities = driver.findElement(By.id("grouptab_5"));
		menuActivities.click();
		
		WebElement product = driver.findElement(By.xpath("//a[text()='Products']"));
		
		product.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," PRODUCTS"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Create Product']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Product']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
	}

	@Given("^Enter Details of the Product \"(.*)\", \"(.*)\"$")
	public void enter_details_of_the_product(String productName,String productPrice) {
		driver.findElement(By.id("name")).sendKeys(productName);
		driver.findElement(By.id("price")).sendKeys(productPrice);
		
		
	}
	@Given("^Click Save$")
	public void click_save() {
		driver.findElement(By.id("SAVE")).click();
	}
	
	@When("^Navigated to View Products Page$")
	public void navigated_to_view_products_page() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Products']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Products']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," PRODUCTS"));
	
	}
	
	@Then("^All Products should be listed \"(.*)\"$")
	public void all_products_should_be_listed(String productName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@field='name']/b/a[contains(text(),'"+productName+"')]")));
		assertEquals(driver.findElement(By.xpath("//td[@field='name']/b/a[contains(text(),'"+productName+"')]")).getText(),productName);
	}

	
	@Then("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void gotoviewmeetingspageandconfirmcreation() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")).click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		assertEquals(driver.findElement(By.xpath("//td[@field='name']")).getText(),"Meeting scheduled for activty3");
	}


	@Then("^Print count of dashlets$")
	public void print_count_dashlets() throws InterruptedException {
				
		
		List<WebElement> dashletElements = driver.findElements(By.xpath("//div[contains(@id,'dashlet_entire')]"));
		
		System.out.println("The number of Dashlets : "+dashletElements.size());
	}
	
	@Then("^Navigate to Sales Leads and CreateLead$")
	public void navigate_to_sales_leads_create_lead() throws InterruptedException {
		WebElement menuSales = driver.findElement(By.id("grouptab_0"));
		menuSales.click();
		
		WebElement menuLeads = driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads' and text()='Leads' and contains(@href,'Sales')]"));
		
		System.out.println(menuLeads.getText());
		menuLeads.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(@class,'module-title')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
		
	}

	@Then("^Fill the details \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void fill_the_details(String salutation, String fname, String lname) throws InterruptedException {
		Thread.sleep(10000);
		
		Select salution = new Select(driver.findElement(By.id("salutation")));
		salution.selectByVisibleText("Mrs.");
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		driver.findElement(By.id("SAVE")).click();
		
	    
	}
	
	@Then("^Navigate to View Leads page to see results \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void navigate_to_view_leads_page_to_see_results(String salutation,String fname, String lname) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("ul.listViewLinkButton_top:nth-child(5) > li:nth-child(1) > a:nth-child(1)")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first_name_advanced")));
		driver.findElement(By.id("first_name_advanced")).clear();
		driver.findElement(By.id("first_name_advanced")).sendKeys(fname);
		driver.findElement(By.id("last_name_advanced")).clear();
		driver.findElement(By.id("last_name_advanced")).sendKeys(lname);
		driver.findElement(By.id("search_form_submit_advanced")).click();
		Thread.sleep(5000);
		List<WebElement> filterElements = driver.findElements(By.xpath("//td[@class=' inlineEdit']/b/a"));
		assertEquals(salutation+fname+" "+lname,filterElements.get(0).getText());
	}


	


}
