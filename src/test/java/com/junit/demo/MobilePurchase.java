package com.junit.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.io.FileHandler;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MobilePurchase {
	static long start;
	public static WebDriver driver;
	static String s;
	
	@BeforeClass
	public static void browserLaunch() throws Exception {
		 System.setProperty("webdriver.edge.driver","C:\\Users\\sujin\\eclipse-workspace\\ExcelReadFile\\target\\msedgedriver.exe");
		 driver = new EdgeDriver();
		 Thread.sleep(2000);
		 String URL = "https://www.flipkart.com/";		 
		driver.get(URL);		 
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void Quit() {
//		driver.quit();
		}
	
	@Before
	public void startingTime() {
		 start = System.currentTimeMillis();	
	}
	@After  
	public void endTime() {
		 long end = System.currentTimeMillis();
		 System.out.println("Time taken is :" + (end-start));
	}
	
	@Test
 public void test01_popupHandle() throws InterruptedException{
        
		try {
		
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='button']")));
		closeBtn.click();
		 
		System.out.println("Method 1");
		}
		catch (Exception e) {
			System.out.println("Could not find button");
		}
 }
	@Test
 public void test02_searchMobile(){
try {

	driver.findElement(By.xpath("(//input[@name='q'])[1]")).sendKeys("Samsung mobiles",Keys.ENTER);
     System.out.println("Method 2");
}
catch(Exception a) {
	System.err.println("Not found");
}

 }	
	@Test
 public void test03_select() throws Exception{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"col col-7-12\"])[1]"))).click();
//			Window Handling
  String parent = driver.getWindowHandle();
 Set<String> allurl = driver.getWindowHandles();
 for(String x : allurl) {
	 if(!parent.equals(x)) {
		 driver.switchTo().window(x);
	 }
 }
	System.out.println("Method 3");
	
 }
	@Test
 public void test04_test() throws Exception{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement start = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class=\"v1zwn21k v1zwn26 _1psv1zeb9 _1psv1ze0\"])[1]")));
	 s = start.getText();
	 System.out.println(s);
	File f = new File("C:\\Users\\sujin\\Documents\\GIT folder\\MobileName.xlsx");
	FileOutputStream d = new FileOutputStream(f);
	XSSFWorkbook book = new XSSFWorkbook();
	XSSFSheet sheet = book.createSheet("TestSheet1");
	XSSFRow row = sheet.createRow(0);
	XSSFCell cell = row.createCell(0);
	cell.setCellValue(s);
	book.write(d);
	book.close();
	try {
   
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\sujin\\Documents\\GIT folder\\MobileImg.png");
        FileHandler.copy(source, destination);
        System.out.println("Screenshot saved successfully!");
        System.out.println("Method 4");

    } catch (Exception e) {
        System.err.println("Failed to take screenshot: " + e.getMessage());
 }
	
	}
	@Test
	public void test05_validation() {
		Assert.assertEquals(s, "Galaxy S26 5G (Cobalt Violet, 512 GB) (12 GB RAM)");
		System.out.println("Method 5");
	}}

	
	
 

