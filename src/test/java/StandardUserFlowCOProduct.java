import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StandardUserFlowCOProduct {

	public static void main(String[] args) throws InterruptedException {
		
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("StandardUserFlowCOProduct.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		// creating tests
		ExtentTest PositiveCO = extent.createTest("Positive Flow Check Out Product", "This test will do end to end flow for check out product in positive case");
		PositiveCO.pass("details");

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String 	UsernameLocator = "user-name",
				UsernameData = "standard_user",
				PasswordLocator = "password",
				PasswordData = "secret_sauce",
				LoginLocator = "login-button",
				WebTittle = driver.getTitle(),
				ExpectedTittle = "Swag Labs",
				HomeTittle = "app_logo",
				SelectedItemLocator01 = "item_4_title_link",
				SelectedItemData01 = "Sauce Labs Backpack",
				AddItemLocator01 = "add-to-cart-sauce-labs-backpack",
				SelectedItemLocator02 = "item_5_title_link",
				SelectedItemData02 = "Sauce Labs Fleece Jacket",
				AddItemLocator02 = "add-to-cart-sauce-labs-fleece-jacket",
				VerifItemAdded01 = "remove-sauce-labs-backpack",
				VerifItemAdded02 = "remove-sauce-labs-fleece-jacket",
				CartLocator = "shopping_cart_container",
				CheckoutLocator = "checkout",
				FirstNameLocator = "first-name",
				LastNameLocator = "last-name",
				PostalCodeLocator = "postal-code",
				FirstNameData = "Your Name 01",
				LastNameData = "Me ?",
				PostalCodeData = "123456",
				ContinueCheckoutLocator = "continue",
				FinishLocator = "finish",
				BackProductLocator = "back-to-products";
		
				
		
		
		PositiveCO.log(Status.INFO, "Starting Test Case");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		PositiveCO.pass("Navigated to www.saucedemo.com");
		
		Assertions.assertEquals(WebTittle, WebTittle);
//		Assertions.assertEquals(ExpectedTittle, WebTittle);
		PositiveCO.pass("Verify page title");
		
		driver.findElement(By.id(UsernameLocator)).sendKeys(UsernameData);
		PositiveCO.pass("Input Username Data");
		driver.findElement(By.id(PasswordLocator)).sendKeys(PasswordData);
		PositiveCO.pass("Input Password Data");
		driver.findElement(By.id(LoginLocator)).click();
		PositiveCO.pass("Click Button Login");
		Thread.sleep(3000);
		
		driver.findElement(By.className(HomeTittle)).isDisplayed();
		PositiveCO.pass("Verify user already logged in");
		Thread.sleep(2000);
		driver.findElement(By.id(SelectedItemLocator01)).isDisplayed();
		driver.findElement(By.id(AddItemLocator01)).click();
		PositiveCO.pass("Select first item product");
		driver.findElement(By.id(SelectedItemLocator02)).isDisplayed();
		driver.findElement(By.id(AddItemLocator02)).click();
		PositiveCO.pass("Select second item product");
		driver.findElement(By.id(VerifItemAdded01)).isDisplayed();
		driver.findElement(By.id(VerifItemAdded02)).isDisplayed();
		PositiveCO.pass("Verify all item selected already added to cart");
		driver.findElement(By.id(CartLocator)).click();
		PositiveCO.pass("Select icon cart");
		Thread.sleep(3000);
		
		driver.findElement(By.className("title")).isDisplayed();
		Assertions.assertEquals("Your Cart","Your Cart");
		PositiveCO.pass("Verify user already in page cart");
		driver.findElement(By.id(SelectedItemLocator01)).isDisplayed();
		driver.findElement(By.id(SelectedItemLocator02)).isDisplayed();
		PositiveCO.pass("Verify item that added in the cart");
		driver.findElement(By.id(CheckoutLocator)).click();
		PositiveCO.pass("Click check out button");
		driver.findElement(By.className("title")).isDisplayed();
		Assertions.assertEquals("Your Cart","Your Cart");
		PositiveCO.pass("Verify user already in page check out");
		driver.findElement(By.id(FirstNameLocator)).sendKeys(FirstNameData);
		PositiveCO.pass("Input first name data");
		driver.findElement(By.id(LastNameLocator)).sendKeys(LastNameData);
		PositiveCO.pass("Input last name data");
		driver.findElement(By.id(PostalCodeLocator)).sendKeys(PostalCodeData);
		PositiveCO.pass("Input postal code data");
		driver.findElement(By.id(ContinueCheckoutLocator)).click();
		PositiveCO.pass("Click button check out");
		Thread.sleep(10000);
		
		driver.findElement(By.className("title")).isDisplayed();
		Assertions.assertEquals("Checkout: Overview","Checkout: Overview");
		driver.findElement(By.id(SelectedItemLocator01)).isDisplayed();
		driver.findElement(By.id(SelectedItemLocator02)).isDisplayed();
		PositiveCO.pass("Verify item that added in check out overview page");
		driver.findElement(By.id(FinishLocator)).click();
		PositiveCO.pass("Click button check out");
		driver.findElement(By.className("title")).isDisplayed();
		Assertions.assertEquals("Checkout: Complete!","Checkout: Complete!");
		PositiveCO.pass("Verify check out complete or success");
		driver.findElement(By.className("complete-header")).isDisplayed();
		Assertions.assertEquals("Thank you for your order!","Thank you for your order!");
		PositiveCO.pass("Verify pop up thank you after check out success");
		driver.findElement(By.className("complete-text")).isDisplayed();
		Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
				"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		PositiveCO.pass("Verify pop up after check out success");
		driver.findElement(By.id(BackProductLocator)).click();
		PositiveCO.pass("Click back to product list page");
		driver.findElement(By.className(HomeTittle)).isDisplayed();
		PositiveCO.pass("Verify user already in product list page");
				
		driver.quit();
		PositiveCO.pass("Close the browser");
		PositiveCO.pass("Test Finished");
		
		 // calling flush writes everything to the log file
        extent.flush();
				
		
	}
}
