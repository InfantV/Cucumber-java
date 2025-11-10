package com.mobilePurchase;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.mobile.resources.Commonactions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Commonactions{

	@Before
	public void beforeMethod() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\eclipse1-workspace\\AprilBatch\\Cucumber-java\\Driver\\msedgedriver.exe");
		EdgeOptions eo= new EdgeOptions();
		eo.addArguments("start-maximized");
		driver=new EdgeDriver(eo);
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@After
	public void afterMethod() {
		System.out.println("After");
		//Browser Quit
	}
}

//@Before
//Backround
//Scenario
//@After