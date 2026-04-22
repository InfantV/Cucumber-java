package com.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks1 {
	public static WebDriver driver;

    @Before
    public void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
