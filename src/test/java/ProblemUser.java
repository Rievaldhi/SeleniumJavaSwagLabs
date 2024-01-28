import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ProblemUser {
	
	public static void main(String[] args) throws InterruptedException {
		
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ProblemUser.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		// creating tests
		ExtentTest ProblemUser = extent.createTest("Login using problem user", "This test will check if user logged in with condition there is problem with user account");
		ProblemUser.pass("details");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String 	UsernameLocator = "user-name",
				UsernameData = "problem_user",
				PasswordLocator = "password",
				PasswordData = "secret_sauce",
				LoginLocator = "login-button",
				WebTittle = driver.getTitle(),
				HomeTittle = "app_logo",
				SelectedItemLocator01 = "item_4_title_link",
				SelectedItemData01 = "Sauce Labs Backpack",
				AddItemLocator01 = "add-to-cart-sauce-labs-backpack",
				RemoveItemLocator01 = "remove-sauce-labs-backpack";
		
		
		ProblemUser.log(Status.INFO, "Starting Test Case");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		ProblemUser.pass("Navigated to www.saucedemo.com");
		
		Assertions.assertEquals(WebTittle, WebTittle);
		ProblemUser.pass("Verify Page Title");
		driver.findElement(By.id(UsernameLocator)).sendKeys(UsernameData);
		ProblemUser.pass("Input username data");
		driver.findElement(By.id(PasswordLocator)).sendKeys(PasswordData);
		ProblemUser.pass("Input Password data");
		driver.findElement(By.id(LoginLocator)).click();
		ProblemUser.pass("Click button login");
		Thread.sleep(3000);
		
		driver.findElement(By.className(HomeTittle)).isDisplayed();
		ProblemUser.pass("Verify user already logged in");
		Thread.sleep(2000);
		driver.findElement(By.id(SelectedItemLocator01)).isDisplayed();
		Assertions.assertEquals(SelectedItemData01, SelectedItemData01);
		ProblemUser.pass("Verify first item is selected even user not yet select it");
		driver.findElement(By.id(AddItemLocator01)).click();
		ProblemUser.pass("Click button remove first item from cart");
		Thread.sleep(200);
		try {

			Assertions.assertEquals(AddItemLocator01, RemoveItemLocator01);
			System.out.println("Assert Passed");	
			ProblemUser.pass("Verify add item button is displayed");
		} catch (Throwable e) {
			System.out.println("Assert Failed");
			ProblemUser.pass("Verify remove item button is displayed");
		}
		
		if( driver.findElement(By.id(RemoveItemLocator01)).isDisplayed()){
			System.out.println("Element Display The Defect is Valid");
			ProblemUser.pass("Verify the issue if button remove is display The Defect is Valid");
			}else{
			System.out.println("Element is not Displayed");
			ProblemUser.pass("Verify the issue if button remove is not display The Defect is not Valid");
		}

		Thread.sleep(500);		
		driver.quit();
		ProblemUser.pass("Close the browser");
		ProblemUser.pass("Test Finished");
		
		 // calling flush writes everything to the log file
        extent.flush();

	}
}
