import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class LockedOutUser {
	
	public static void main(String[] args) throws InterruptedException {
		
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("LockedOutUser.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		// creating tests
		ExtentTest LockedUser = extent.createTest("Login using locked out user", "This test will check if user logged in with condition locked out user");
		LockedUser.pass("details");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String 	UsernameLocator = "user-name",
				UsernameData = "locked_out_user",
				PasswordLocator = "password",
				PasswordData = "secret_sauce",
				LoginLocator = "login-button",
				WebTittle = driver.getTitle();
		
		LockedUser.log(Status.INFO, "Starting Test Case");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		LockedUser.pass("Navigated to www.saucedemo.com");
		
		Assertions.assertEquals(WebTittle, WebTittle);
		LockedUser.pass("Verify page title");
		driver.findElement(By.id(UsernameLocator)).sendKeys(UsernameData);
		LockedUser.pass("Input username data");
		driver.findElement(By.id(PasswordLocator)).sendKeys(PasswordData);
		LockedUser.pass("Input password data");
		driver.findElement(By.id(LoginLocator)).click();
		LockedUser.pass("Click button login");
		driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed();
		LockedUser.pass("Verify error message appears");
		Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", "Epic sadface: Sorry, this user has been locked out.");
		LockedUser.pass("Verify wording error message is valid");
		Thread.sleep(3000);
		
		driver.quit();
		LockedUser.pass("Close the browser");
		LockedUser.pass("Test Finished");
		
		 // calling flush writes everything to the log file
        extent.flush();
        
	}
}
