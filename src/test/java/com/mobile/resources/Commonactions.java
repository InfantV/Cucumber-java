package com.mobile.resources;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


	}


