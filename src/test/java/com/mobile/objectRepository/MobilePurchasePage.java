package com.mobile.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobile.resources.Commonactions;

public class MobilePurchasePage extends Commonactions {
	
	public MobilePurchasePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "q")
	private WebElement searchBox;

	@FindBy(xpath = "//div[contains(text(),'iPhone')][1]")
	private WebElement prod1;
	
	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getProd1() {
		return prod1;
	

	}
	}

}
