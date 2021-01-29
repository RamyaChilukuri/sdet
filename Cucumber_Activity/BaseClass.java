package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
	static WebDriverWait wait;
	
	  public static void createWebDriver() {
	    	driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 50);
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }


}
