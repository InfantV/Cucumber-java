package com.mobilePurchase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {
	static WebDriver driver;
	static long start;
	static WebDriverWait wait;
	@DataProvider(name="mobile")
	public Object mobileName() {
		return new Object[][] {{"realme"}};
	}
	@Parameters("URL")
	@BeforeClass
	public static void browserLaunch(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void quit()
	{
		driver.quit();
		System.out.println("quit");
	}
	@BeforeMethod
	public void startTime() {
		start=System.currentTimeMillis();
		
	}
	@AfterMethod
	public void endTime() {
		long end=System.currentTimeMillis();
		System.out.println("After Time taken is:"+(end-start));
		
	}
	@Test(priority=1,groups="group1")
	public void clickClose() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b3wTlE\"]")));
        close.click();
	}
	@Test(priority=2,groups="group1",dataProvider="mobile")
	public void searchMobiles(String name) {
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
		
	}
	@Test(priority=3,groups="group1")
	public void selectFirstProduct() throws Exception
	{
     List<WebElement> products=driver.findElements(By.xpath("//div[@class=\"QSCKDh dLgFEE\"]"));
     for(WebElement p:products) {
    	 if(p.isDisplayed()) {
    	 p.click();
    	 break;
    	 } 
     }
		
	}
	@Test(priority=4,groups="group2")
	public void windowsHandling()
	{
		String win=driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		for(String s:allwin) {
			if(!win.equals(s)) {
				driver.switchTo().window(s);
			}
		}
        String text=driver.findElement(By.xpath("//h1[@class=\"v1zwn21k v1zwn26 _1psv1zeb9 _1psv1ze0\"]")).getText();
		System.out.println(text);
	}
	@Test(priority=5,groups="group2")
	public void screenshot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\USER\\eclipse-workspace\\JUnit\\target.screenshot.png");
		FileUtils.copyFile(src, target);
		
	}
	



}
