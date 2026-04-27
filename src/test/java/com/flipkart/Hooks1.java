package com.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mobile.resources.Commonactions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.classfile.impl.Options;

public class Hooks1 extends Commonactions{
	public static WebDriver driver;

    @Before
    public void setup() {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions option=new ChromeOptions();
    	option.addArguments("start-maximized");
    	driver = new ChromeDriver(option);
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
