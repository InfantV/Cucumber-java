package com.mobile.resources;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.flipkart.Hooks1;

import io.cucumber.messages.types.Duration;

public class Commonactions {
	
	public static WebDriver driver;
	
	public void windowshandling() {
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
	
        public void kanchana() {
        	System.out.println(" my name is kanchana");
            
        }
        
        public void divya () {
        	System.out.println("Hello I'm Divya");
        }
        
        
public void insertData(WebElement ele, String prod) {
		
		ele.sendKeys(prod,Keys.ENTER);

	}
public void takeScreenshot() throws IOException {
TakesScreenshot ts=(TakesScreenshot)Hooks1.driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File target=new File("F:\\Elba_Learning\\Projects\\Cucumber-java\\target.screenshot.png");
FileUtils.copyFile(src, target);
}


	}


