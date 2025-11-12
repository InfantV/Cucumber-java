package com.mobilePurchase;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.mobile.objectRepository.MobilePurchasePage;
import com.mobile.resources.Commonactions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseStep extends Commonactions {
	
	static WebDriver driver;
	
	Commonactions ca = new Commonactions();
	MobilePurchasePage m = new MobilePurchasePage();
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
//		System.out.println("browser launched");
//		WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\eclipse1-workspace\\AprilBatch\\Cucumber-java\\Driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	}

	@And("Login into the Flipkart page")
	public void login_into_the_flipkart_page() {
//	  System.out.println("logged in the flipkart page");
		String url = "https://www.flipkart.com/";
	  driver.get(url);
//	  driver.manage().window().maximize();

	}

	@When("User search the mobile")
	public void user_search_the_mobile() {
//		System.out.println("realme");
		
		ca.insertData(m.getSearchBox(), "iPhone");
		m.getProd1().click();
	}

	@And("User select the product")
	public void user_select_the_product() {
	 System.out.println("product selection done");
	
	}

	@And("User handling the window")
	public void user_handling_the_window() {
	    System.out.println("winodows handlind done");
	    ca.windowshandling();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + driver.getTitle());
                driver.close(); 
            }
        }
	}

	@Then("User validating the product")
	public void user_validating_the_product() {
	    System.out.println("validated");
	}
	@When("User search the mobile by using one dimensional List")
	public void user_search_the_mobile_by_using_one_dimensional_list(DataTable dataTable) throws InterruptedException {
		List<String> mobiles = dataTable.asList(String.class);
		for(int i=0;i<mobiles.size();i++) { 
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(Keys.CONTROL + "a");
        search.sendKeys(Keys.DELETE);
		search.sendKeys((mobiles.get(i)),Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'"+mobiles.get(i)+"')][1]")).click();
		}
	  }	
	public void suvitha() {
		System.out.println("child two");
	}

	
//	@When("User search the mobile by using one dimensional map")
//	public void user_search_the_mobile_by_using_one_dimensional_map(DataTable dataTable) throws InterruptedException {
//		Map<String, String> asMap = dataTable.asMap(String.class,String.class);
//		for(Entry<String, String> x:asMap.entrySet()) {
//		WebElement search=driver.findElement(By.name("q"));			
//		search.sendKeys(Keys.CONTROL + "a");
//	    search.sendKeys(Keys.DELETE);
//	    
//		search.sendKeys(asMap.get(x.getKey()),Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[contains(text(),'"+asMap.get(x.getKey())+"')][1]")).click();
//		}		    		
//		}
//		
//		@When("User search the mobile {string}")
//		public void user_search_the_mobile(String names) throws InterruptedException {
//			WebElement search=driver.findElement(By.name("q"));
//			search.sendKeys(Keys.CONTROL + "a");
//	        search.sendKeys(Keys.DELETE);
//			search.sendKeys((names),Keys.ENTER);
//			driver.findElement(By.xpath("//div[contains(text(),'"+names+"')][1]")).click();	
//			
//	
//	}
}
