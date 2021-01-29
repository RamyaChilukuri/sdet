package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AlchemyJobs {
	 WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait ;
	    
	    
	    @Given("^User is on Job page$")
	    public void loginPage() {
	        //Setup instances
	        //driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	    }
	    @Given("^User is on Jobs page$")
	    public void JobsPage() {
	        //Setup instances
	        
	        wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/");
	        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/nav[1]/div[1]/ul[1]/li[1]/a[1]")).click();
	    }
	  
	    
	    @When("^User enters \"(.*)\" and \"(.*)\"$")
	    public void user_enters_and(String username, String password) throws Throwable {
	        //Enter username from Feature file
	        driver.findElement(By.id("user_login")).sendKeys(username);
	        //Enter password from Feature file
	        driver.findElement(By.id("user_pass")).sendKeys(password);
	        //Click Login
	        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	    }
	    
	    @Then("^Add new user with email \"(.*)\"$")
	    public void createNewUser(String email) {
	      driver.findElement(By.xpath("//body/div[@id='wpwrap']/div[@id='adminmenumain']/div[@id='adminmenuwrap']/ul[@id='adminmenu']/li[@id='menu-users']/a[1]/div[3]")).click();
	      driver.findElement(By.xpath("//body/div[@id='wpwrap']/div[@id='adminmenumain']/div[@id='adminmenuwrap']/ul[@id='adminmenu']/li[@id='menu-users']/ul[1]/li[3]/a[1]")).click();
	      driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(email);
	      driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	      driver.findElement(By.xpath("//input[@id='createusersub']")).click();
	     
	    }
	    
	    @And("^Verify user is created$")
	    public void VerifyMessage() {
	        //Close browser
	    	String msg = driver.findElement(By.xpath("//body/div[@id='wpwrap']/div[@id='wpcontent']/div[@id='wpbody']/div[@id='wpbody-content']/div[4]/div[1]/p[1]")).getText();
	       Assert.assertEquals(msg, "Please enter a password.");
	       //New user created
	    }
	    @When("^User searches for job and change job type$")
	    public void JobSearch() {
	        //Close browser
	    	driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("SDET Automation");
	    	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")).click();
	       
	    }
	    @Then("^Find job and apply for job$")
	    public void AppyJob() {
	        //
	    	//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/div[1]/div[1]")).click();
	    	//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).click();
	    }
	    @When("^User goes to post a job$")
	    public void PostJobPage() {
	        //
	    	driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]")).click();
	    	
	    }
	    @Then("^Post a job with details \"(.*)\" \"(.*)\" and \"(.*)\"$")
	    public void PostJob(String email, String title, String location) {
	        //
	    	driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys(email);
	    	driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(title);
	    	driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys(location);
	    }
	    @And("^Verify job is posted$")
	    public void VerifyPostJob() {
	        //
	    	
	    	
	    }
	    
	    @And("^Close the Browser$")
	    public void closeBrowser() {
	        //Close browser
	        driver.close();
	    }

}
