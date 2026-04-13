package com.mobilePurchase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	static WebDriver driver;
	static long start;
	static WebDriverWait wait;
	@BeforeClass
	public static void browserLaunch()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void quit()
	{
		driver.quit();
		System.out.println("quit");
	}
	@Before
	public void startTime() {
		start=System.currentTimeMillis();
		
	}
	@After
	public void endTime() {
		long end=System.currentTimeMillis();
		System.out.println("After Time taken is:"+(end-start));
		
	}
	@Test
	public void method1() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b3wTlE\"]")));
        close.click();
	}
	@Test
	public void method2() {
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("mobiles");
		search.sendKeys(Keys.ENTER);
		
	}
	@Test
	public void method3() throws Exception
	{
     List<WebElement> products=driver.findElements(By.xpath("//div[@class=\"QSCKDh dLgFEE\"]"));
     String firstproduct="";
     for(WebElement p:products) {
    	 if(p.isDisplayed()) {
    	firstproduct=p.getText();
    	 p.click();
    	 break;
    	 } 
     }
     writeToExcel(firstproduct);
		
	}
	@Test
	public void method4()
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
	@Test
	public void method5() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\USER\\eclipse-workspace\\JUnit\\target.screenshot.png");
		FileUtils.copyFile(src, target);
		
	}
	public void writeToExcel(String data) throws Exception {

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Products");

	    XSSFRow row = sheet.createRow(0);
	    row.createCell(0).setCellValue(data);

	    FileOutputStream file = new FileOutputStream("C:\\Users\\USER\\eclipse-workspace\\JUnit\\target.Product.xlsx");
	    workbook.write(file);

	    file.close();
	    workbook.close();
	}



}
